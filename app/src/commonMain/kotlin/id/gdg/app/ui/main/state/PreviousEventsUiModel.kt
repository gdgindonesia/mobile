package id.gdg.app.ui.main.state

import id.gdg.app.ui.main.uimodel.toEventContent
import id.gdg.app.common.UiState
import id.gdg.event.model.EventModel

data class PreviousEventsUiModel(
    val state: UiState,
    val previousEvents: List<EventModel>,
) {

    fun toEventContent() = previousEvents.map { it.toEventContent() }

    companion object {
        val Empty get() = PreviousEventsUiModel(
            state = UiState.Loading,
            previousEvents = listOf()
        )
    }
}