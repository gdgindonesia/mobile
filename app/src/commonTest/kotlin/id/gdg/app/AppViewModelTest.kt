package id.gdg.app

import app.cash.turbine.test
import id.gdg.app.robot.AppViewModelRobot
import id.gdg.app.ui.AppEvent
import id.gdg.app.ui.state.ChapterUiModel
import id.gdg.app.ui.state.common.UiState
import id.gdg.app.ui.state.partial.PreviousEventsUiModel
import id.gdg.app.ui.state.partial.UpcomingEventUiModel
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
    fun `invoked ChangeChapterId it will return selected chapter id`() {
        val expectedValue = 1
        viewModel.sendEvent(AppEvent.ChangeChapterId(expectedValue))

        runBlocking {
            robot.getCurrentChapterUseCase().test {
                assertTrue { expectMostRecentItem() == expectedValue }
            }
        }
    }

    @Test
    fun `invoked InitialContent it will return upcoming and previous event`() {
        val events = robot.createEvents()

        robot.upcomingEventUseCase.setData(Result.success(events.first()))
        robot.previousEventUseCase.setData(Result.success(events))

        val expectedValue = ChapterUiModel(
            upcomingEvent = UpcomingEventUiModel(
                state = UiState.Success,
                upcomingEvent = events.first()
            ),
            previousEvents = PreviousEventsUiModel(
                state = UiState.Success,
                previousEvents = events
            )
        )

        viewModel.sendEvent(AppEvent.ChangeChapterId(1))
        viewModel.sendEvent(AppEvent.InitialContent)

        runBlocking {
            viewModel.chapterUiState.test {
                assertTrue { expectMostRecentItem() == expectedValue }
            }
        }
    }

    @Test
    fun `invoked FetchPreviousEvent it will return top three of previous events`() {
        val events = robot.createEvents()
        robot.previousEventUseCase.setData(Result.success(events))

        viewModel.sendEvent(AppEvent.FetchPreviousEvent)

        runBlocking {
            viewModel.chapterUiState.test {
                val actualValue = expectMostRecentItem()
                assertTrue { actualValue.previousEvents.state is UiState.Success }
                assertTrue { actualValue.previousEvents.previousEvents.size == 3 }
            }
        }
    }

    @Test
    fun `invoked FetchPreviousEvent when previous event not found it will return empty list`() {
        robot.previousEventUseCase.setData(Result.success(emptyList()))

        viewModel.sendEvent(AppEvent.FetchPreviousEvent)

        runBlocking {
            viewModel.chapterUiState.test {
                val actualValue = expectMostRecentItem()
                assertTrue { actualValue.previousEvents.state is UiState.Success }
                assertTrue { actualValue.previousEvents.previousEvents.isEmpty() }
            }
        }
    }

    @Test
    fun `invoked FetchPreviousEvent when network error it will return a fail state`() {
        robot.previousEventUseCase.setData(Result.failure(Throwable("network error")))

        viewModel.sendEvent(AppEvent.FetchPreviousEvent)

        runBlocking {
            viewModel.chapterUiState.test {
                assertTrue { expectMostRecentItem().previousEvents.state is UiState.Fail }
            }
        }
    }

    @Test
    fun `invoked FetchUpcomingEvent it will return upcoming event`() {
        val events = robot.createEvents()
        robot.upcomingEventUseCase.setData(Result.success(events.first()))

        viewModel.sendEvent(AppEvent.FetchUpcomingEvent)

        runBlocking {
            viewModel.chapterUiState.test {
                val actualValue = expectMostRecentItem()
                assertTrue { actualValue.upcomingEvent.state is UiState.Success }
                assertTrue { actualValue.upcomingEvent.upcomingEvent != null }
            }
        }
    }

    @Test
    fun `invoked FetchUpcomingEvent when there is no event it will return empty event`() {
        robot.upcomingEventUseCase.setData(Result.success(null))

        viewModel.sendEvent(AppEvent.FetchUpcomingEvent)

        runBlocking {
            viewModel.chapterUiState.test {
                val actualValue = expectMostRecentItem()
                assertTrue { actualValue.upcomingEvent.state is UiState.Success }
                assertTrue { actualValue.upcomingEvent.upcomingEvent == null }
            }
        }
    }

    @Test
    fun `invoked FetchUpcomingEvent when network error it will return a fail state`() {
        robot.upcomingEventUseCase.setData(Result.failure(Throwable("network error")))

        viewModel.sendEvent(AppEvent.FetchUpcomingEvent)

        runBlocking {
            viewModel.chapterUiState.test {
                assertTrue { expectMostRecentItem().upcomingEvent.state is UiState.Fail }
            }
        }
    }
}