package id.gdg.event.domain.mapper

import id.gdg.event.data.entity.Event
import id.gdg.event.model.EventModel

fun Event.toEventModel(): EventModel {
    return EventModel(
        id = id,
        title = title,
        chapterTitle = chapterTitle,
        descriptionShort = descriptionShort,
        eventImageUrl = picture,
        startDate = startDate,
        timezoneAbbreviation = timezoneAbbreviation,
    )
}