package id.gdg.event.domain

import id.gdg.event.data.repository.EventRepository
import id.gdg.event.domain.mapper.toEventModel
import id.gdg.event.model.EventModel

class GetPreviousEventUseCase(
    private val repository: EventRepository
) {

    suspend operator fun invoke(chapterId: Int): List<EventModel> {
        return repository.previousEvent(chapterId)
            .map { it.toEventModel() }
    }
}