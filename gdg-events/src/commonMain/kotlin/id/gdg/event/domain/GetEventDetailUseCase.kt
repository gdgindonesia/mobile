package id.gdg.event.domain

import id.gdg.event.data.repository.EventDetailRepository

class GetEventDetailUseCase(private val repository: EventDetailRepository) {

    // TODO: Create a Data Model for necessary attributes
    suspend operator fun invoke(eventId: Int): String {
        return repository.eventDetail(eventId)
            .map { it.title }
            .getOrDefault("")
    }
}