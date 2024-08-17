package id.gdg.event.stub

import id.gdg.event.data.entity.EventDetail
import id.gdg.event.data.fake.EventDetailFake
import id.gdg.event.data.repository.EventDetailRepository

class EventDetailRepositoryStub : EventDetailRepository {

    private val mockData = EventDetailFake()
    private var isSucceed = true

    fun setStatus(value: Boolean) {
        isSucceed = value
    }

    override suspend fun eventDetail(eventId: Int): Result<EventDetail> {
        return if (isSucceed) {
            Result.success(mockData.create<EventDetail>())
        } else {
            Result.failure(IllegalStateException("Cannot fetch the API, please check the internet connection"))
        }
    }
}