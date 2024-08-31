package id.gdg.app

import androidx.lifecycle.viewModelScope
import id.gdg.app.update.ChapterEventUpdate
import id.gdg.app.update.ChapterUpdate
import id.gdg.app.update.EventDetailUpdate
import id.gdg.app.common.Update
import id.gdg.app.common.UpdateableViewModel
import id.gdg.app.ui.AppEvent
import id.gdg.app.ui.state.AppUiModel
import id.gdg.app.ui.state.EventDetailUiModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class AppViewModel(
    private val chapterUpdate: ChapterUpdate,
    private val chapterEventUpdate: ChapterEventUpdate,
    private val eventDetailUpdate: EventDetailUpdate
) : UpdateableViewModel() {

    val uiState: StateFlow<AppUiModel> = combine(
        chapterUpdate.chapterUiState,
        chapterEventUpdate.eventsUiState
    ) { chapters, events ->
        AppUiModel(
            eventUiState = events,
            chapterUiState = chapters
        )
    }.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5_000),
        AppUiModel()
    )

    val eventDetailUiState = eventDetailUpdate.eventDetailUiState
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5_000),
            EventDetailUiModel.Empty
        )

    private var _action = MutableSharedFlow<AppEvent>(replay = 50)

    override fun updates(): List<Update> {
        return listOf(
            chapterUpdate,
            chapterEventUpdate,
            eventDetailUpdate
        )
    }

    init {
        setupLoop()

        viewModelScope.launch {
            _action.collect(::eventHandlers)
        }
    }

    fun sendEvent(event: AppEvent) {
        _action.tryEmit(event)
    }
}