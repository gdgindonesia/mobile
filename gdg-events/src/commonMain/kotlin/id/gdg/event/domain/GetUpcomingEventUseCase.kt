package id.gdg.event.domain

import id.gdg.event.data.repository.EventRepository
import id.gdg.event.domain.mapper.toEventModel
import id.gdg.event.model.EventModel

interface GetUpcomingEventUseCase {

    suspend operator fun invoke(chapterId: Int): EventModel?
}

class GetUpcomingEventUseCaseImpl(private val repository: EventRepository) : GetUpcomingEventUseCase {

    override suspend operator fun invoke(chapterId: Int): EventModel? {
        return repository.upcomingEvent(chapterId)
            .getOrDefault(null)
            ?.toEventModel()
    }
}