package id.gdg.app.update

import id.gdg.app.common.Update
import id.gdg.app.common.UpdateScope
import id.gdg.app.common.UiState
import id.gdg.app.common.asUiState
import id.gdg.app.ui.AppEvent
import id.gdg.app.ui.state.EventDetailUiModel
import id.gdg.event.domain.GetEventDetailUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

interface EventDetailUpdate : Update {

    val eventDetailUiState: Flow<EventDetailUiModel>
}

class EventDetailUpdateImpl(
    private val eventDetailUseCase: GetEventDetailUseCase,
    private val updateScope: UpdateScope,
) : EventDetailUpdate, UpdateScope by updateScope {

    private var _eventDetailUiState = MutableStateFlow(EventDetailUiModel.Empty)

    override val eventDetailUiState: Flow<EventDetailUiModel>
        get() = _eventDetailUiState.asStateFlow()

    override fun handleEvent(event: AppEvent) {
        if (event is AppEvent.EventDetail) {
            fetchEventDetail(event.eventId)
        }
    }

    private fun fetchEventDetail(eventId: Int) {
        _eventDetailUiState.update { it.copy(state = UiState.Loading) }

        scope.launch {
            val result = eventDetailUseCase(eventId)

            withContext(Dispatchers.Main) {
                _eventDetailUiState.update {
                    it.copy(
                        state = result.asUiState(),
                        detail = result.getOrNull()
                    )
                }
            }
        }
    }
}