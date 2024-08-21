package id.gdg.event.domain

import id.gdg.event.data.repository.EventRepository
import id.gdg.event.domain.mapper.toEventModel
import id.gdg.event.model.EventModel

interface GetPreviousEventUseCase {

    suspend operator fun invoke(chapterId: Int): List<EventModel>
}

class GetPreviousEventUseCaseImpl(private val repository: EventRepository) : GetPreviousEventUseCase {

    override suspend operator fun invoke(chapterId: Int): List<EventModel> {
        return repository.previousEvent(chapterId)
            .getOrDefault(listOf())
            .map { it.toEventModel() }
    }
}