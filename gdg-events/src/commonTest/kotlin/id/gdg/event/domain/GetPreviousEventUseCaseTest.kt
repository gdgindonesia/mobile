package id.gdg.event.domain

import id.gdg.event.stub.EventRepositoryStub
import id.gdg.event.stub.EventRepositoryThrowableStub
import kotlinx.coroutines.runBlocking
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class GetPreviousEventUseCaseTest {

    @Test
    fun `invoked should return a list of previous events`() {
        runBlocking {
            val repository = EventRepositoryStub()
            val useCase = GetPreviousEventUseCase(repository)

            assertEquals(3, useCase(0).size)
        }
    }

    @Test
    fun `invoked should return a throwable error`() {
        runBlocking {
            val repository = EventRepositoryThrowableStub()
            val useCase = GetPreviousEventUseCase(repository)

            assertFailsWith<IllegalStateException> { useCase(0) }
        }
    }
}