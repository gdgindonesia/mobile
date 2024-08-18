package id.gdg.event.domain

import id.gdg.event.model.MultiEventModel

class GetEventsUseCase(
    private val upComingEventUseCase: GetUpComingEventUseCase,
    private val previousEventUseCase: GetPreviousEventUseCase,
) {

    suspend operator fun invoke(chapterId: Int): MultiEventModel {
        val upComingEventUseCase = upComingEventUseCase(chapterId)
        val previousEventUseCase = previousEventUseCase(chapterId)

        return MultiEventModel(
            upComingEventUseCase,
            previousEventUseCase
        )
    }
}