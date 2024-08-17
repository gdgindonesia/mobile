package id.gdg.event.data.repository

import id.gdg.event.stub.EventApiStub
import kotlinx.coroutines.runBlocking
import kotlin.test.Test
import kotlin.test.assertTrue

class EventDetailRepositoryTest {

    @Test
    fun `eventDetail should return a event detail`() {
        runBlocking {
            val api = EventApiStub()
            api.setStatus(true)

            val repository = EventDetailRepositoryImpl(api)
            assertTrue { repository.eventDetail(0).isSuccess }
        }
    }

    @Test
    fun `eventDetail should thrown an exception`() {
        runBlocking {
            val api = EventApiStub()
            api.setStatus(false)

            val repository = EventDetailRepositoryImpl(api)
            assertTrue { repository.eventDetail(0).isFailure }
        }
    }
}