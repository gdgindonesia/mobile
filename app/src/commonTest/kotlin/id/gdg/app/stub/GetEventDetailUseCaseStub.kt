package id.gdg.app.stub

import id.gdg.event.domain.GetEventDetailUseCase
import id.gdg.event.model.EventDetailModel

class GetEventDetailUseCaseStub : GetEventDetailUseCase {

    private var model: Result<EventDetailModel?>? = null

    fun setData(eventDetailModel: Result<EventDetailModel?>) {
        model = eventDetailModel
    }

    override suspend fun invoke(eventId: Int) = model ?: error("haven't set the data yet.")
}