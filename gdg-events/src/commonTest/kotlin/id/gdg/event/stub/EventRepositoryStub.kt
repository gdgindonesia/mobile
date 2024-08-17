package id.gdg.event.stub

import id.gdg.event.data.entity.Events
import id.gdg.event.data.entity.Events.Event
import id.gdg.event.data.fake.EventFake
import id.gdg.event.data.repository.EventRepository

class EventRepositoryStub : EventRepository {

    private val mockData = EventFake()
    private var isSucceed = true

    fun setStatus(value: Boolean) {
        isSucceed = value
    }

    override suspend fun upcomingEvent(chapterId: Int): Result<Event?> {
        return if (isSucceed) {
            Result.success(mockData.create<Events>().events.firstOrNull())
        } else {
            Result.failure(IllegalStateException("Cannot fetch the API, please check the internet connection"))
        }
    }

    override suspend fun previousEvent(chapterId: Int): Result<List<Event>> {
        return if (isSucceed) {
            Result.success(mockData.create<Events>().events)
        } else {
            Result.failure(IllegalStateException("Cannot fetch the API, please check the internet connection"))
        }
    }
}