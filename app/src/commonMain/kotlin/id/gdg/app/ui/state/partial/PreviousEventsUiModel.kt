package id.gdg.app.ui.state.partial

import id.gdg.app.common.UiState
import id.gdg.event.model.EventModel

data class PreviousEventsUiModel(
    val state: UiState,
    val data: List<EventModel>,
) {

    companion object {
        val Empty get() = PreviousEventsUiModel(
            state = UiState.Loading,
            data = listOf()
        )
    }
}