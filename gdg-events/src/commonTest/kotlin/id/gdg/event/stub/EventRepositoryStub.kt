package id.gdg.event.stub

import id.gdg.event.data.entity.Event
import id.gdg.event.data.fake.eventFake
import id.gdg.event.data.repository.EventRepository

class EventRepositoryStub : EventRepository {

    override suspend fun upcomingEvent(chapterId: Int): Event? {
        return eventFake().events.firstOrNull()
    }

    override suspend fun previousEvent(chapterId: Int): List<Event> {
        return eventFake().events
    }
}