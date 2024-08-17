package id.gdg.event.stub

import id.gdg.event.data.entity.Event
import id.gdg.event.data.repository.EventRepository

class EventRepositoryThrowableStub : EventRepository {

    override suspend fun upcomingEvent(chapterId: Int): Event? {
        error("Cannot fetch the API, please check the internet connection")
    }

    override suspend fun previousEvent(chapterId: Int): List<Event> {
        error("Cannot fetch the API, please check the internet connection")
    }
}