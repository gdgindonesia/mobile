package id.gdg.event.model

data class EventModel(
    val id: Long,
    val title: String,
    val chapterTitle: String,
    val descriptionShort: String,
    val eventImageUrl: String,
    val startDate: String,
    val timezoneAbbreviation: String,
    val audienceType: String
)