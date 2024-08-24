package id.gdg.app.ui.state.partial

import id.gdg.app.ui.state.common.UiState
import id.gdg.event.model.EventModel

data class PreviousEventsUiModel(
    val state: UiState,
    val previousEvents: List<EventModel>,
) {

    companion object {
        val Empty get() = PreviousEventsUiModel(
            state = UiState.Loading,
            previousEvents = listOf()
        )
    }
}