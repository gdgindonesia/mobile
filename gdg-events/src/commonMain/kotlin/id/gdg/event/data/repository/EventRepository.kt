package id.gdg.event.data.repository

import id.gdg.event.data.EventStatus
import id.gdg.event.data.entity.Event
import id.gdg.event.data.source.EventApi

interface EventRepository {

    suspend fun upcomingEvent(chapterId: Int): Event?
    suspend fun previousEvent(chapterId: Int): List<Event>
}

class EventRepositoryImpl(private val api: EventApi) : EventRepository {

    override suspend fun upcomingEvent(chapterId: Int): Event? {
        return api.fetchEvent(
            chapterId = chapterId,
            pageSize = 1, // get the latest one
            status = EventStatus.Upcoming.value
        ).events.firstOrNull()
    }

    override suspend fun previousEvent(chapterId: Int): List<Event> {
        return api.fetchEvent(
            chapterId = chapterId,
            pageSize = 3, // get top 3 previous events
            status = EventStatus.Previous.value
        ).events
    }
}