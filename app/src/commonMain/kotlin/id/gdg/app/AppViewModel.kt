package id.gdg.app

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.gdg.app.ui.state.AppEvent
import id.gdg.app.ui.state.ChapterUiModel
import id.gdg.app.ui.state.EventUiModel
import id.gdg.chapter.domain.GetChapterIdUseCase
import id.gdg.chapter.domain.GetChapterListUseCase
import id.gdg.chapter.domain.SetChapterIdUseCase
import id.gdg.event.domain.GetEventDetailUseCase
import id.gdg.event.domain.GetPreviousEventUseCase
import id.gdg.event.domain.GetUpcomingEventUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
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

    private var _action = MutableSharedFlow<AppEvent>(replay = 50)

    private var _chapterUiState = MutableStateFlow(ChapterUiModel())
    val chapterUiState get() = _chapterUiState.asStateFlow()

    private var _eventUiState = MutableStateFlow(EventUiModel())
    val eventUiState get() = _eventUiState.asStateFlow()

    init {
        observeOnChapterIdChanged()

        viewModelScope.launch {
            _action.collect(::observeActionEvent)
        }
    }

    fun sendEvent(event: AppEvent) {
        _action.tryEmit(event)
    }

    fun getChapterList() = chapterListUseCase()

    private fun observeOnChapterIdChanged() {
        viewModelScope.launch {
            getCurrentChapterUseCase()
                .collect {
                    val currentChapterId = it ?: return@collect
                    fetchEvent(currentChapterId)
                }
        }
    }

    private fun observeActionEvent(action: AppEvent) {
        when (action) {
            is AppEvent.EventDetail -> fetchEventDetail(action.eventId)
            is AppEvent.ChangeChapterId -> shouldChangeCurrentChapterId(action.chapterId)
        }
    }

    private fun shouldChangeCurrentChapterId(chapterId: Int) {
        viewModelScope.launch {
            setCurrentChapterUseCase(chapterId)
        }
    }

    private fun fetchEvent(chapterId: Int) {
        fetchPreviousEvent(chapterId)
        fetchUpcomingEvents(chapterId)
    }

    private fun fetchPreviousEvent(chapterId: Int) {
        viewModelScope.launch {
            val result = previousEventUseCase(chapterId)

            withContext(Dispatchers.Main) {
                _chapterUiState.update {
                    it.copy(previousEvents = result)
                }
            }
        }
    }

    private fun fetchUpcomingEvents(chapterId: Int) {
        viewModelScope.launch {
            val result = upcomingEventUseCase(chapterId)

            withContext(Dispatchers.Main) {
                _chapterUiState.update {
                    it.copy(upcomingEvent = result)
                }
            }
        }
    }

    private fun fetchEventDetail(eventId: Int) {
        viewModelScope.launch {
            val result = eventDetailUseCase(eventId)

            withContext(Dispatchers.Main) {
                _eventUiState.update {
                    it.copy(detail = result)
                }
            }
        }
    }
}