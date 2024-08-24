package id.gdg.event.domain.mapper

import id.gdg.event.data.entity.EventDetail
import id.gdg.event.data.entity.Events.Event
import id.gdg.event.model.EventDetailModel
import id.gdg.event.model.EventModel

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
        startDate = startDate,
        timezoneAbbreviation = timezoneAbbreviation,
    )
}

fun EventDetail.toEventDetailModel(): EventDetailModel {
    return EventDetailModel(title)
}