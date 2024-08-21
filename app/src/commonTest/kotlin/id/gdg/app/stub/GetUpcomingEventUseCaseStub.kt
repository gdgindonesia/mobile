package id.gdg.app.stub

import id.gdg.event.domain.GetUpcomingEventUseCase
import id.gdg.event.model.EventModel

class GetUpcomingEventUseCaseStub : GetUpcomingEventUseCase {

    private var event: EventModel? = null

    fun setData(eventModel: EventModel?) {
        event = eventModel
    }

    override suspend fun invoke(chapterId: Int) = event
}