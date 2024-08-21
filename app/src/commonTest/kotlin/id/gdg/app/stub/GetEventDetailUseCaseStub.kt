package id.gdg.app.stub

import id.gdg.event.domain.GetEventDetailUseCase
import id.gdg.event.model.EventDetailModel

class GetEventDetailUseCaseStub : GetEventDetailUseCase {

    private var model: EventDetailModel? = null

    fun setData(eventDetailModel: EventDetailModel?) {
        model = eventDetailModel
    }

    override suspend fun invoke(eventId: Int) = model
}