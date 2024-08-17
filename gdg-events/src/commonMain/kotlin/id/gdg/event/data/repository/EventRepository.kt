package id.gdg.event.data.repository

import id.gdg.event.data.EventStatus
import id.gdg.event.data.entity.Events.Event
import id.gdg.event.data.source.EventApi

interface EventRepository {

    suspend fun upcomingEvent(chapterId: Int): Result<Event?>
    suspend fun previousEvent(chapterId: Int): Result<List<Event>>
}

class EventRepositoryImpl(private val api: EventApi) : EventRepository {

    override suspend fun upcomingEvent(chapterId: Int): Result<Event?> {
        return try {
            Result.success(
                api.fetchEvent(
                    chapterId = chapterId,
                    pageSize = 1, // get the latest one
                    status = EventStatus.Upcoming.value
                ).events.firstOrNull()
            )
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun previousEvent(chapterId: Int): Result<List<Event>> {
        return try {
            Result.success(
                api.fetchEvent(
                    chapterId = chapterId,
                    pageSize = 3, // get top 3 previous events
                    status = EventStatus.Previous.value
                ).events
            )
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}