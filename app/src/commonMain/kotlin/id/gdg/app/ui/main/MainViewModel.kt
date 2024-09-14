package id.gdg.app.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.gdg.app.ui.main.state.ChapterUiModel
import id.gdg.app.ui.detail.EventDetailUiModel
import id.gdg.app.common.UiState
import id.gdg.app.common.asUiState
import id.gdg.app.ui.main.state.PreviousEventsUiModel
import id.gdg.app.ui.main.state.UpcomingEventUiModel
import id.gdg.chapter.domain.GetChapterIdUseCase
import id.gdg.chapter.domain.GetChapterListUseCase
import id.gdg.chapter.domain.SetChapterIdUseCase
import id.gdg.event.domain.GetPreviousEventUseCase
import id.gdg.event.domain.GetUpcomingEventUseCase
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainViewModel(
    // Chapters
    private val getCurrentChapterUseCase: GetChapterIdUseCase,
    private val setCurrentChapterUseCase: SetChapterIdUseCase,

    // Events
    private val upcomingEventUseCase: GetUpcomingEventUseCase,
    private val previousEventUseCase: GetPreviousEventUseCase
) : ViewModel() {

    private var currentChapterId = 0

    private var _action = MutableSharedFlow<MainEvent>(replay = 50)

    private var _upcomingEvent = MutableStateFlow(UpcomingEventUiModel.Empty)
    private var _previousEvents = MutableStateFlow(PreviousEventsUiModel.Empty)

    val chapterUiState: StateFlow<ChapterUiModel> = combine(
        _upcomingEvent,
        _previousEvents
    ) { upcoming, previous ->
        ChapterUiModel(upcoming, previous)
    }.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5_000),
        ChapterUiModel.Default
    )

    private var _eventDetailUiState = MutableStateFlow(EventDetailUiModel.Empty)
    val eventDetailUiState get() = _eventDetailUiState.asStateFlow()

    init {
        observeOnChapterIdChanged()

        viewModelScope.launch {
            _action.collect(::observeActionEvent)
        }
    }

    fun sendEvent(event: MainEvent) {
        _action.tryEmit(event)
    }

    private fun observeOnChapterIdChanged() {
        viewModelScope.launch {
            getCurrentChapterUseCase()
                .collect {
                    val chapterId = it ?: return@collect
                    currentChapterId = chapterId

                    // immediately fetch init
                    sendEvent(MainEvent.InitialContent)
                }
        }
    }

    private fun observeActionEvent(action: MainEvent) {
        when (action) {
            is MainEvent.ChangeChapterId -> shouldChangeCurrentChapterId(action.chapterId)
            is MainEvent.InitialContent -> {
                sendEvent(MainEvent.FetchPreviousEvent)
                sendEvent(MainEvent.FetchUpcomingEvent)
            }
            is MainEvent.FetchPreviousEvent -> fetchPreviousEvent(currentChapterId)
            is MainEvent.FetchUpcomingEvent -> fetchUpcomingEvents(currentChapterId)
        }
    }

    private fun shouldChangeCurrentChapterId(chapterId: Int) {
        viewModelScope.launch {
            setCurrentChapterUseCase(chapterId)
        }
    }

    private fun fetchPreviousEvent(chapterId: Int) {
        _previousEvents.update { it.copy(state = UiState.Loading) }

        viewModelScope.launch {
            val result = previousEventUseCase(chapterId)

            _previousEvents.update {
                it.copy(
                    state = result.asUiState(),
                    previousEvents = result.getOrNull() ?: emptyList()
                )
            }
        }
    }

    private fun fetchUpcomingEvents(chapterId: Int) {
        _upcomingEvent.update { it.copy(state = UiState.Loading) }

        viewModelScope.launch {
            val result = upcomingEventUseCase(chapterId)

            _upcomingEvent.update {
                it.copy(
                    state = result.asUiState(),
                    upcomingEvent = result.getOrNull()
                )
            }
        }
    }
}