package id.gdg.event.stub

import id.gdg.event.data.entity.EventDetail
import id.gdg.event.data.entity.Events
import id.gdg.event.data.fake.EventDetailFake
import id.gdg.event.data.fake.EventFake
import id.gdg.event.data.source.EventApi

class EventApiStub : EventApi {

    private val eventFakeData = EventFake()
    private val eventDetailFakeData = EventDetailFake()

    private var isSucceed = true

    fun setStatus(value: Boolean) {
        isSucceed = value
    }

    override suspend fun fetchEvent(
        chapterId: Int,
        pageSize: Int,
        status: String,
        order: String
    ): Events {
        return if (isSucceed) {
            eventFakeData.create<Events>()
        } else {
            error("network fail")
        }
    }

    override suspend fun fetchEventDetail(eventId: Int): EventDetail {
        return if (isSucceed) {
            eventDetailFakeData.create<EventDetail>()
        } else {
            error("network fail")
        }
    }
}