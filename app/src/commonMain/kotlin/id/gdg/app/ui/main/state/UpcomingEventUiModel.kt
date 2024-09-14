package id.gdg.app.ui.main.state

import id.gdg.app.common.UiState
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