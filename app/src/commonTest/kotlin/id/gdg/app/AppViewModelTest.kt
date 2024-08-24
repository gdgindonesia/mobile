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
    fun `when ChangeChapterId is invoked then selected chapter ID is returned`() {
        val expectedValue = 1
        viewModel.sendEvent(AppEvent.ChangeChapterId(expectedValue))

        runBlocking {
            robot.getCurrentChapterUseCase().test {
                assertTrue { expectMostRecentItem() == expectedValue }
            }
        }
    }

    @Test
    fun `when InitialContent is invoked then upcoming and previous events are returned`() {
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
    fun `when FetchPreviousEvent is invoked then the top three previous events are returned`() {
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
    fun `when FetchPreviousEvent is invoked and no previous events exist then an empty list is returned`() {
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
    fun `when FetchPreviousEvent is invoked and a network error occurs then a Fail state is returned`() {
        robot.previousEventUseCase.setData(Result.failure(Throwable("network error")))

        viewModel.sendEvent(AppEvent.FetchPreviousEvent)

        runBlocking {
            viewModel.chapterUiState.test {
                assertTrue { expectMostRecentItem().previousEvents.state is UiState.Fail }
            }
        }
    }

    @Test
    fun `when FetchUpcomingEvent is invoked then the upcoming event is returned`() {
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
    fun `when FetchUpcomingEvent is invoked and no upcoming event exists then an empty event is returned`() {
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
    fun `when FetchUpcomingEvent is invoked and a network error occurs then a Fail state is returned`() {
        robot.upcomingEventUseCase.setData(Result.failure(Throwable("network error")))

        viewModel.sendEvent(AppEvent.FetchUpcomingEvent)

        runBlocking {
            viewModel.chapterUiState.test {
                assertTrue { expectMostRecentItem().upcomingEvent.state is UiState.Fail }
            }
        }
    }
}