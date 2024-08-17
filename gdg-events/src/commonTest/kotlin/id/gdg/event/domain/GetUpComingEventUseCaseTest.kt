package id.gdg.event.domain

import id.gdg.event.stub.EventRepositoryStub
import id.gdg.event.stub.EventRepositoryThrowableStub
import kotlinx.coroutines.runBlocking
import kotlin.test.Test
import kotlin.test.assertFailsWith
import kotlin.test.assertTrue

class GetUpComingEventUseCaseTest {

    @Test
    fun `invoked should return a upcoming event`() {
        runBlocking {
            val repository = EventRepositoryStub()
            val useCase = GetUpComingEventUseCase(repository)

            assertTrue { useCase(0) != null }
        }
    }

    @Test
    fun `invoked should return a throwable error`() {
        runBlocking {
            val repository = EventRepositoryThrowableStub()
            val useCase = GetUpComingEventUseCase(repository)

            assertFailsWith<IllegalStateException> { useCase(0) }
        }
    }
}