package id.gdg.event.domain

import id.gdg.event.data.repository.EventDetailRepository

class GetEventDetailUseCase(private val repository: EventDetailRepository) {

    suspend operator fun invoke(eventId: Int): String {
        return repository.eventDetail(eventId)
            .map { it.title }
            .getOrDefault("")
    }
}