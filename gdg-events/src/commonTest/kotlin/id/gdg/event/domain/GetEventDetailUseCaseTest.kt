package id.gdg.event.domain

import id.gdg.event.data.entity.EventDetail
import id.gdg.event.data.fake.EventDetailFake
import id.gdg.event.domain.mapper.toEventDetailModel
import id.gdg.event.stub.EventDetailRepositoryStub
import kotlinx.coroutines.runBlocking
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class GetEventDetailUseCaseTest {

    @Test
    fun `invoked should return title of event detail based on event id`() {
       runBlocking {
           val repository = EventDetailRepositoryStub()
           repository.setStatus(true)

           val useCase = GetEventDetailUseCaseImpl(repository)

           val expectedValue = EventDetailFake().create<EventDetail>().toEventDetailModel()

           assertTrue { useCase(1).isSuccess }
           assertTrue { useCase(1).getOrNull() == expectedValue }
       }
    }

    @Test
    fun `invoked should return a throwable error`() {
        runBlocking {
            val repository = EventDetailRepositoryStub()
            repository.setStatus(false)

            val useCase = GetEventDetailUseCaseImpl(repository)
            assertTrue { useCase(0).isFailure }
        }
    }
}