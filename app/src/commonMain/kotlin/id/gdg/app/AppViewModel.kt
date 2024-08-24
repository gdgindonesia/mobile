package id.gdg.app

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.gdg.app.ui.AppEvent
import id.gdg.app.ui.state.ChapterUiModel
import id.gdg.app.ui.state.EventDetailUiModel
import id.gdg.app.ui.state.common.UiState
import id.gdg.app.ui.state.common.asUiState
import id.gdg.app.ui.state.partial.PreviousEventsUiModel
import id.gdg.app.ui.state.partial.UpcomingEventUiModel
import id.gdg.chapter.domain.GetChapterIdUseCase
import id.gdg.chapter.domain.GetChapterListUseCase
import id.gdg.chapter.domain.SetChapterIdUseCase
import id.gdg.event.domain.GetEventDetailUseCase
import id.gdg.event.domain.GetPreviousEventUseCase
import id.gdg.event.domain.GetUpcomingEventUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AppViewModel(
    // Chapters
    private val chapterListUseCase: GetChapterListUseCase,
    private val getCurrentChapterUseCase: GetChapterIdUseCase,
    private val setCurrentChapterUseCase: SetChapterIdUseCase,

    // Events
    private val upcomingEventUseCase: GetUpcomingEventUseCase,
    private val previousEventUseCase: GetPreviousEventUseCase,
    private val eventDetailUseCase: GetEventDetailUseCase,
) : ViewModel() {

    private var currentChapterId = 0

    private var _action = MutableSharedFlow<AppEvent>(replay = 50)

    private var _upcomingEvent = MutableStateFlow(UpcomingEventUiModel.Empty)
    private var _previousEvents = MutableStateFlow(PreviousEventsUiModel.Empty)

    val chapterList get() = chapterListUseCase()

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

    private var _eventDetailUiState = MutableStateFlow(EventDetailUiModel())
    val eventDetailUiState get() = _eventDetailUiState.asStateFlow()

    init {
        observeOnChapterIdChanged()

        viewModelScope.launch {
            _action.collect(::observeActionEvent)
        }
    }

    fun sendEvent(event: AppEvent) {
        _action.tryEmit(event)
    }

    private fun observeOnChapterIdChanged() {
        viewModelScope.launch {
            getCurrentChapterUseCase()
                .collect {
                    val chapterId = it ?: return@collect
                    currentChapterId = chapterId
                }
        }
    }

    private fun observeActionEvent(action: AppEvent) {
        when (action) {
            is AppEvent.ChangeChapterId -> shouldChangeCurrentChapterId(action.chapterId)
            is AppEvent.InitialContent -> {
                sendEvent(AppEvent.FetchPreviousEvent)
                sendEvent(AppEvent.FetchUpcomingEvent)
            }

            is AppEvent.FetchPreviousEvent -> fetchPreviousEvent(currentChapterId)
            is AppEvent.FetchUpcomingEvent -> fetchUpcomingEvents(currentChapterId)
            is AppEvent.EventDetail -> fetchEventDetail(action.eventId)
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

    private fun fetchEventDetail(eventId: Int) {
        viewModelScope.launch {
            val result = eventDetailUseCase(eventId)

            withContext(Dispatchers.Main) {
                _eventDetailUiState.update {
                    it.copy(detail = result.getOrNull())
                }
            }
        }
    }
}