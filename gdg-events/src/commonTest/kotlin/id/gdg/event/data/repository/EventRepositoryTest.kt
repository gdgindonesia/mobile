package id.gdg.event.data.repository

import id.gdg.event.stub.EventApiStub
import kotlinx.coroutines.runBlocking
import kotlin.test.Test
import kotlin.test.assertTrue

class EventRepositoryTest {

    @Test
    fun `upcomingEvent should return an event`() {
        runBlocking {
            val api = EventApiStub()
            api.setStatus(true)

            val repository = EventRepositoryImpl(api)
            assertTrue { repository.upcomingEvent(0).isSuccess }
        }
    }

    @Test
    fun `previousEvent should return top three list of event`() {
        runBlocking {
            val api = EventApiStub()
            api.setStatus(true)

            val repository = EventRepositoryImpl(api)
            assertTrue { repository.previousEvent(0).isSuccess }
            assertTrue { repository.previousEvent(0).getOrNull()?.size == 3 }
        }
    }

    @Test
    fun `upcomingEvent should throw an exception`() {
        runBlocking {
            val api = EventApiStub()
            api.setStatus(false)

            val repository = EventRepositoryImpl(api)
            assertTrue { repository.upcomingEvent(0).isFailure }
        }
    }

    @Test
    fun `previousEvent should throw an exception`() {
        runBlocking {
            val api = EventApiStub()
            api.setStatus(false)

            val repository = EventRepositoryImpl(api)
            assertTrue { repository.previousEvent(0).isFailure }
        }
    }
}