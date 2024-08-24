package id.gdg.app.stub

import id.gdg.event.domain.GetUpcomingEventUseCase
import id.gdg.event.model.EventModel

class GetUpcomingEventUseCaseStub : GetUpcomingEventUseCase {

    private var event: Result<EventModel?>? = null

    fun setData(eventModel: Result<EventModel?>) {
        event = eventModel
    }

    override suspend fun invoke(chapterId: Int) = event ?: error("haven't set the data yet.")
}