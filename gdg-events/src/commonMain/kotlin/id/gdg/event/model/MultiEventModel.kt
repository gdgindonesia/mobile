package id.gdg.event.model

data class MultiEventModel(
    val previousEvent: EventModel? = null,
    val upcomingEvents: List<EventModel> = emptyList()
)