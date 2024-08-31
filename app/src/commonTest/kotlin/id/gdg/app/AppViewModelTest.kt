package id.gdg.app

import app.cash.turbine.test
import id.gdg.app.common.UiState
import id.gdg.app.robot.AppViewModelRobot
import id.gdg.app.ui.AppEvent
import id.gdg.event.model.EventDetailModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.koin.test.KoinTest
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertTrue

@OptIn(ExperimentalCoroutinesApi::class)
class AppViewModelTest : KoinTest {

    private val robot = AppViewModelRobot
    private val viewModel by lazy {
        robot.createViewModel()
    }

    @BeforeTest
    fun setUp() {
        Dispatchers.setMain(AppViewModelRobot.testDispatcher)
        robot.setUp()
    }

    @AfterTest
    fun tearDown() {
        Dispatchers.resetMain()
        robot.tearDown()
    }

    @Test
    fun `when ChangeChapterId is invoked then selected chapter ID is returned`() {
        val expectedValue = 1
        viewModel.sendEvent(AppEvent. ChangeChapterId(expectedValue))

        runBlocking {
            robot.getCurrentChapterUseCase().test {
                assertTrue { expectMostRecentItem() == expectedValue }
            }
        }
    }

    @Test
    fun `when FetchPreviousEvent is invoked then the top three previous events are returned`() {
        val events = robot.createEvents()
        robot.previousEventUseCase.setData(Result.success(events))

        viewModel.sendEvent(AppEvent. FetchPreviousEvent(1))

        runBlocking {
            viewModel.uiState.test {
                val actualValue = expectMostRecentItem()
                assertTrue { actualValue.eventUiState.previousEvents.state is UiState.Success }
                assertTrue { actualValue.eventUiState.previousEvents.data.size == 3 }
            }
        }
    }

    @Test
    fun `when FetchPreviousEvent is invoked and no previous events exist then an empty list is returned`() {
        robot.previousEventUseCase.setData(Result.success(emptyList()))

        viewModel.sendEvent(AppEvent. FetchPreviousEvent(1))

        runBlocking {
            viewModel.uiState.test {
                val actualValue = expectMostRecentItem()
                assertTrue { actualValue.eventUiState.previousEvents.state is UiState.Success }
                assertTrue { actualValue.eventUiState.previousEvents.data.isEmpty() }
            }
        }
    }

    @Test
    fun `when FetchPreviousEvent is invoked and a network error occurs then a Fail state is returned`() {
        robot.previousEventUseCase.setData(Result.failure(Throwable("network error")))

        viewModel.sendEvent(AppEvent. FetchPreviousEvent(1))

        runBlocking {
            viewModel.uiState.test {
                assertTrue { expectMostRecentItem().eventUiState.previousEvents.state is UiState.Fail }
            }
        }
    }

    @Test
    fun `when FetchUpcomingEvent is invoked then the upcoming event is returned`() {
        val events = robot.createEvents()
        robot.upcomingEventUseCase.setData(Result.success(events.first()))

        viewModel.sendEvent(AppEvent. FetchUpcomingEvent(1))

        runBlocking {
            viewModel.uiState.test {
                val actualValue = expectMostRecentItem()
                assertTrue { actualValue.eventUiState.upcomingEvent.state is UiState.Success }
                assertTrue { actualValue.eventUiState.upcomingEvent.data != null }
            }
        }
    }

    @Test
    fun `when FetchUpcomingEvent is invoked and no upcoming event exists then an empty event is returned`() {
        robot.upcomingEventUseCase.setData(Result.success(null))

        viewModel.sendEvent(AppEvent. FetchUpcomingEvent(0))

        runBlocking {
            viewModel.uiState.test {
                val actualValue = expectMostRecentItem()
                assertTrue { actualValue.eventUiState.upcomingEvent.state is UiState.Success }
                assertTrue { actualValue.eventUiState.upcomingEvent.data == null }
            }
        }
    }

    @Test
    fun `when FetchUpcomingEvent is invoked and a network error occurs then a Fail state is returned`() {
        robot.upcomingEventUseCase.setData(Result.failure(Throwable("network error")))

        viewModel.sendEvent(AppEvent. FetchUpcomingEvent(0))

        runBlocking {
            viewModel.uiState.test {
                assertTrue { expectMostRecentItem().eventUiState.upcomingEvent.state is UiState.Fail }
            }
        }
    }

    @Test
    fun `when EventDetail is invoked then the the event details is returned`() {
        val expectedValue = EventDetailModel(
            title = "DevFest!"
        )

        robot.eventDetailUseCase.setData(Result.success(expectedValue))

        viewModel.sendEvent(AppEvent. EventDetail(1))

        runBlocking {
            viewModel.eventDetailUiState.test {
                val actualValue = expectMostRecentItem()
                assertTrue { actualValue.state is UiState.Success }
                assertTrue { actualValue.detail != null }
            }
        }
    }

    @Test
    fun `when EventDetail is invoked and invalid event id then an empty event detail is returned`() {
        robot.eventDetailUseCase.setData(Result.success(null))

        viewModel.sendEvent(AppEvent. EventDetail(-1))

        runBlocking {
            viewModel.eventDetailUiState.test {
                val actualValue = expectMostRecentItem()
                assertTrue { actualValue.state is UiState.Success }
                assertTrue { actualValue.detail == null }
            }
        }
    }

    @Test
    fun `when EventDetail is invoked and a network error occurs then a Fail state is returned`() {
        robot.eventDetailUseCase.setData(Result.failure(Throwable("network error")))

        viewModel.sendEvent(AppEvent.EventDetail(0))

        runBlocking {
            viewModel.eventDetailUiState.test {
                assertTrue { expectMostRecentItem().state is UiState.Fail }
            }
        }
    }
}