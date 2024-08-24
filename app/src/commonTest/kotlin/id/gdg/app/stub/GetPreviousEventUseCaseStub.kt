package id.gdg.app.stub

import id.gdg.event.domain.GetPreviousEventUseCase
import id.gdg.event.model.EventModel

class GetPreviousEventUseCaseStub : GetPreviousEventUseCase {

    private var _data: Result<List<EventModel>>? = null

    fun setData(data: Result<List<EventModel>>) {
        _data = data
    }

    override suspend fun invoke(chapterId: Int) = _data ?: error("haven't set the data yet.")
}