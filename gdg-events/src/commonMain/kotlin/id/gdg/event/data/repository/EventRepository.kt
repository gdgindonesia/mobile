package id.gdg.event.data.repository

import id.gdg.event.data.entity.Event
import id.gdg.event.data.source.EventApi

interface EventRepository {

    suspend fun upcomingEvent(chapterId: Int): Event?
    suspend fun topHighlightPastEvent(chapterId: Int): List<Event>
}

class EventRepositoryImpl(private val api: EventApi) : EventRepository {

    override suspend fun upcomingEvent(chapterId: Int): Event? {
        return api.upcomingEvent(chapterId).events.firstOrNull()
    }

    override suspend fun topHighlightPastEvent(chapterId: Int): List<Event> {
        return api.pastEvent(chapterId).events
    }
}