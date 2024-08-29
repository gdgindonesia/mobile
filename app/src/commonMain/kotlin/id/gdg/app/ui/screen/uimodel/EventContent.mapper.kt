package id.gdg.app.ui.screen.uimodel

import id.gdg.event.model.EventModel
import id.gdg.ui.component.EventContent

fun EventModel.toEventContent(): EventContent {
    return EventContent(
        id = "$id",
        bannerUrl = eventImageUrl,
        eventName = title,
        date = startDate,
        type = audienceType.toString()
    )
}