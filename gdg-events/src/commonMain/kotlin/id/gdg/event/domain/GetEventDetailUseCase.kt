package id.gdg.event.domain

import id.gdg.event.data.repository.EventDetailRepository
import id.gdg.event.model.EventDetailModel

interface GetEventDetailUseCase {

    // TODO: Create a Data Model for necessary attributes
    suspend operator fun invoke(eventId: Int): EventDetailModel?
}

class GetEventDetailUseCaseImpl(private val repository: EventDetailRepository) : GetEventDetailUseCase {

    override suspend operator fun invoke(eventId: Int): EventDetailModel? {
        return repository.eventDetail(eventId)
            .map { EventDetailModel(it.title) }
            .getOrDefault(null)
    }
}