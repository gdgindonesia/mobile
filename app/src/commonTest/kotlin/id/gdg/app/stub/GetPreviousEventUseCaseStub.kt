package id.gdg.app.stub

import id.gdg.event.domain.GetPreviousEventUseCase
import id.gdg.event.model.EventModel

class GetPreviousEventUseCaseStub : GetPreviousEventUseCase {

    private var _data = mutableListOf<EventModel>()

    fun setData(data: List<EventModel>) {
        _data.clear()
        _data.addAll(data)
    }

    override suspend fun invoke(chapterId: Int) = _data
}