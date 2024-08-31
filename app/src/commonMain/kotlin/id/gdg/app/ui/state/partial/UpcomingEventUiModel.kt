package id.gdg.app.ui.state.partial

import id.gdg.app.common.UiState
import id.gdg.event.model.EventModel

data class UpcomingEventUiModel(
    val state: UiState,
    val data: EventModel?,
) {

    companion object {
        val Empty get() = UpcomingEventUiModel(
            state = UiState.Loading,
            data = null
        )
    }
}