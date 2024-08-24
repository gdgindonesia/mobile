package id.gdg.event.domain

import id.gdg.event.data.repository.EventDetailRepository
import id.gdg.event.domain.mapper.toEventDetailModel
import id.gdg.event.model.EventDetailModel

interface GetEventDetailUseCase {

    suspend operator fun invoke(eventId: Int): Result<EventDetailModel?>
}

class GetEventDetailUseCaseImpl(private val repository: EventDetailRepository) : GetEventDetailUseCase {

    override suspend operator fun invoke(eventId: Int): Result<EventDetailModel?> {
        return repository.eventDetail(eventId)
            .map { it.toEventDetailModel() }
    }
}