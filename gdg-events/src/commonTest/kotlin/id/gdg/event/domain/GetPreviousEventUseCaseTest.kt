package id.gdg.event.domain

import id.gdg.event.stub.EventRepositoryStub
import kotlinx.coroutines.runBlocking
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class GetPreviousEventUseCaseTest {

    @Test
    fun `invoked should return a list of previous events`() {
        runBlocking {
            val repository = EventRepositoryStub()
            repository.setStatus(true)

            val useCase = GetPreviousEventUseCaseImpl(repository)

            assertTrue { useCase(1).isSuccess }
        }
    }

    @Test
    fun `invoked should return a throwable error`() {
        runBlocking {
            val repository = EventRepositoryStub()
            repository.setStatus(false)

            val useCase = GetPreviousEventUseCaseImpl(repository)
            assertTrue { useCase(0).isFailure }
        }
    }
}