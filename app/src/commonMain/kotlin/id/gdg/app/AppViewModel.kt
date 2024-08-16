package id.gdg.app

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.gdg.chapter.domain.GetChapterListUseCase
import id.gdg.event.domain.GetPreviousEventUseCase
import id.gdg.event.domain.GetUpComingEventUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AppViewModel(
    private val chapterListUseCase: GetChapterListUseCase,
    private val upComingEventUseCase: GetUpComingEventUseCase,
    private val previousEventUseCase: GetPreviousEventUseCase,
) : ViewModel() {

    private var _previousEvents = MutableStateFlow<List<String>>(emptyList())
    val previousEvents get() = _previousEvents.asStateFlow()

    fun getUpcomingEvent() {
        viewModelScope.launch {
            val chapter = chapterListUseCase().first()
            val highlightPreviousEvent = previousEventUseCase(chapter.id)

            withContext(Dispatchers.Main) {
                val result = highlightPreviousEvent.map { it.title }
                _previousEvents.emit(result)
            }
        }
    }
}