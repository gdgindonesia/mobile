package id.gdg.event.data.repository

import id.gdg.event.data.entity.EventDetail
import id.gdg.event.data.source.EventApi

interface EventDetailRepository {

    suspend fun eventDetail(eventId: Int): Result<EventDetail>
}

class EventDetailRepositoryImpl(private val api: EventApi) : EventDetailRepository {

    override suspend fun eventDetail(eventId: Int): Result<EventDetail> {
        return try {
            Result.success(api.fetchEventDetail(eventId))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}