package id.gdg.app

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.gdg.app.ui.state.AppEvent
import id.gdg.app.ui.state.AppUiModel
import id.gdg.chapter.domain.GetChapterIdUseCase
import id.gdg.chapter.domain.GetChapterListUseCase
import id.gdg.chapter.domain.SetChapterIdUseCase
import id.gdg.event.domain.GetEventDetailUseCase
import id.gdg.event.domain.GetEventsUseCase
import id.gdg.event.domain.GetPreviousEventUseCase
import id.gdg.event.domain.GetUpComingEventUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AppViewModel(
    // Chapters
    private val chapterListUseCase: GetChapterListUseCase,
    private val getCurrentChapterUseCase: GetChapterIdUseCase,
    private val setCurrentChapterUseCase: SetChapterIdUseCase,

    // Events
    private val eventsUseCase: GetEventsUseCase,
) : ViewModel() {

    private var _action = MutableSharedFlow<AppEvent>(replay = 50)

    private var _state = MutableStateFlow(AppUiModel())
    val state get() = _state.asStateFlow()

    init {
        viewModelScope.launch {
            getCurrentChapterUseCase()
                .filterNotNull()
                .combine(_action) { chapterId, action ->
                    when (action) {
                        is AppEvent.InitActiveChapterId -> updateActiveChapterIdOnState(chapterId)
                        is AppEvent.SetActiveChapterId -> setChapterId(action.id)
                        is AppEvent.FetchEvent -> fetchEvent(chapterId)
                    }
                }
                .flowOn(Dispatchers.IO)
                .collect()
        }
    }

    fun sendEvent(event: AppEvent) {
        _action.tryEmit(event)
    }

    fun getChapterList() = chapterListUseCase()

    private fun setChapterId(chapterId: Int) {
        viewModelScope.launch {
            setCurrentChapterUseCase(chapterId)
        }
    }

    private fun updateActiveChapterIdOnState(chapterId: Int) {
        viewModelScope.launch {
            withContext(Dispatchers.Main) {
                _state.update {
                    it.copy(activeChapterId = chapterId)
                }
            }
        }
    }

    private fun fetchEvent(chapterId: Int) {
        viewModelScope.launch {
            val eventsUseCase = eventsUseCase(chapterId)

            withContext(Dispatchers.Main) {
                _state.update {
                    it.copy(events = eventsUseCase)
                }
            }
        }
    }
}