package id.gdg.event.domain

import id.gdg.event.data.repository.EventRepository
import id.gdg.event.domain.mapper.toEventModel
import id.gdg.event.model.EventModel

class GetUpComingEventUseCase(
    private val repository: EventRepository
) {

    suspend operator fun invoke(chapterId: Int): EventModel? {
        return repository.upcomingEvent(chapterId)?.toEventModel()
    }
}