package id.gdg.event.domain

import id.gdg.event.stub.EventRepositoryStub
import kotlinx.coroutines.runBlocking
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class GetUpComingEventUseCaseTest {

    @Test
    fun `invoked should return a upcoming event`() {
        runBlocking {
            val repository = EventRepositoryStub()
            repository.setStatus(true)

            val useCase = GetUpcomingEventUseCaseImpl(repository)

            assertTrue { useCase(0) != null }
        }
    }

    @Test
    fun `invoked should return a throwable error`() {
        runBlocking {
            val repository = EventRepositoryStub()
            repository.setStatus(false)

            val useCase = GetUpcomingEventUseCaseImpl(repository)
            assertEquals(null, useCase(0))
        }
    }
}