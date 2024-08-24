package id.gdg.app.ui.state.partial

import id.gdg.app.ui.state.common.UiState
import id.gdg.event.model.EventModel

data class UpcomingEventUiModel(
    val state: UiState,
    val upcomingEvent: EventModel?,
) {

    companion object {
        val Empty get() = UpcomingEventUiModel(
            state = UiState.Loading,
            upcomingEvent = null
        )
    }
}