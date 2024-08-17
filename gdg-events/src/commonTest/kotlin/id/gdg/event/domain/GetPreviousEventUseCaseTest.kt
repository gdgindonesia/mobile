package id.gdg.event.domain

import id.gdg.event.stub.EventRepositoryStub
import kotlinx.coroutines.runBlocking
import kotlin.test.Test
import kotlin.test.assertEquals

class GetPreviousEventUseCaseTest {

    @Test
    fun `invoked should return a list of previous events`() {
        runBlocking {
            val repository = EventRepositoryStub()
            repository.setStatus(true)

            val useCase = GetPreviousEventUseCase(repository)

            assertEquals(3, useCase(0).size)
        }
    }

    @Test
    fun `invoked should return a throwable error`() {
        runBlocking {
            val repository = EventRepositoryStub()
            repository.setStatus(false)

            val useCase = GetPreviousEventUseCase(repository)
            assertEquals(listOf(), useCase(0))
        }
    }
}