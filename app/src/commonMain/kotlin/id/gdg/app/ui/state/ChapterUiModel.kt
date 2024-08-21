package id.gdg.app.ui.state

import id.gdg.event.model.EventModel

data class ChapterUiModel(
    val upcomingEvent: EventModel? = null,
    val previousEvents: List<EventModel> = emptyList()
)