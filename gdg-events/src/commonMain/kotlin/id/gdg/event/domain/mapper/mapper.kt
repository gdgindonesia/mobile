package id.gdg.event.domain.mapper

import id.gdg.event.data.entity.EventDetail
import id.gdg.event.data.entity.Events.Event
import id.gdg.event.model.EventDetailModel
import id.gdg.event.model.EventModel
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant

fun List<Event>.toEventModels(): List<EventModel> {
    return map { it.toEventModel() }
}

fun Event.toEventModel(): EventModel {
    return EventModel(
        id = id,
        title = title,
        chapterTitle = chapterTitle,
        descriptionShort = descriptionShort,
        eventImageUrl = picture,
        startDate = formatDate(startDate),
        timezoneAbbreviation = timezoneAbbreviation,
        audienceType = audienceType.lowercase()
    )
}

fun EventDetail.toEventDetailModel(): EventDetailModel {
    return EventDetailModel(title)
}

internal fun formatDate(dateString: String): String {
    val date = Instant.parse(dateString)
    val now = Clock.System.now()

    val duration = now - date
    val days = duration.inWholeDays
    val months = (days / 30).toInt() // Approximate months
    val years = (days / 365).toInt() // Approximate years

    return when {
        years > 0 -> "$years year${if (years > 1) "s" else ""} ago"
        months > 0 -> "$months month${if (months > 1) "s" else ""} ago"
        days > 0 -> "$days day${if (days > 1) "s" else ""} ago"
        else -> "today"
    }
}