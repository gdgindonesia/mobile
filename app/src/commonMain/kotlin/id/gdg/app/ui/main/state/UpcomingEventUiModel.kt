package id.gdg.app.ui.main.state

import id.gdg.app.common.UiState
import id.gdg.app.ui.main.uimodel.toEventContent
import id.gdg.event.model.EventModel
import id.gdg.ui.component.EventContent

data class UpcomingEventUiModel(
    val state: UiState,
    val upcomingEvent: EventModel?,
) {

    fun toEventContent() = upcomingEvent?.toEventContent()

    companion object {
        val Empty get() = UpcomingEventUiModel(
            state = UiState.Loading,
            upcomingEvent = null
        )
    }
}