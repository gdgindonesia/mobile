package id.gdg.app

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.gdg.chapter.domain.GetChapterIdUseCase
import id.gdg.chapter.domain.GetChapterListUseCase
import id.gdg.chapter.domain.SetChapterIdUseCase
import id.gdg.event.domain.GetEventDetailUseCase
import id.gdg.event.domain.GetPreviousEventUseCase
import id.gdg.event.domain.GetUpComingEventUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AppViewModel(
    // Chapters
    private val chapterListUseCase: GetChapterListUseCase,
    private val getCurrentChapterUseCase: GetChapterIdUseCase,
    private val setCurrentChapterUseCase: SetChapterIdUseCase,

    // Events
    private val upComingEventUseCase: GetUpComingEventUseCase,
    private val previousEventUseCase: GetPreviousEventUseCase,
    private val eventDetailUseCase: GetEventDetailUseCase,
) : ViewModel() {

    private var _previousEvents = MutableStateFlow<List<String>>(emptyList())
    val previousEvents get() = _previousEvents.asStateFlow()

    init {
        viewModelScope.launch {
            getCurrentChapterUseCase()
                .flowOn(Dispatchers.IO)
                .collect { chapterId ->
                    if (chapterId == null) return@collect

                    val highlightPreviousEvent = previousEventUseCase(chapterId)

                    withContext(Dispatchers.Main) {
                        val result = highlightPreviousEvent.map { it.title }
                        _previousEvents.emit(result)
                    }
                }
        }
    }

    fun getChapterList() = chapterListUseCase()

    fun setChapterId(chapterId: Int) {
        viewModelScope.launch {
            setCurrentChapterUseCase(chapterId)
        }
    }
}