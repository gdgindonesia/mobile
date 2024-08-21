package id.gdg.app

import app.cash.turbine.test
import id.gdg.app.robot.AppViewModelRobot
import id.gdg.app.ui.state.AppEvent
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
    fun `when the chapter has upcoming event it will return a single upcoming event`() = runBlocking {
        val expectedValue = robot.createEvents()
        robot.upcomingEventUseCase.setData(expectedValue.first())

        viewModel.sendEvent(AppEvent.ChangeChapterId(1))
        viewModel.chapterUiState.test {
            assertTrue { expectMostRecentItem().upcomingEvent != null }
        }
    }

    @Test
    fun `whatever chapterId at initial state has changed it will return a list of previous event`() = runBlocking {
        val expectedValue = robot.createEvents()
        robot.previousEventUseCase.setData(expectedValue)

        viewModel.sendEvent(AppEvent.ChangeChapterId(1))
        viewModel.chapterUiState.test {
            assertTrue { expectMostRecentItem().previousEvents == expectedValue }
        }
    }

    @Test
    fun `when user pick wrong chapterId it will return empty list of previous event and empty upcoming event`() = runBlocking {
        robot.previousEventUseCase.setData(listOf())
        robot.upcomingEventUseCase.setData(null)

        viewModel.sendEvent(AppEvent.ChangeChapterId(0))
        viewModel.chapterUiState.test {
            val result = expectMostRecentItem()

            assertTrue { result.previousEvents.isEmpty() }
            assertTrue { result.upcomingEvent == null }
        }
    }

    @Test
    fun `when click one of the correct event it will render the event detail`() = runBlocking {
        robot.eventDetailUseCase.setData(
            EventDetailModel(title = "Hi!")
        )

        viewModel.sendEvent(AppEvent.EventDetail(1))
        viewModel.eventUiState.test {
            assertTrue { expectMostRecentItem().detail != null }
        }
    }

    @Test
    fun `when click one of the incorrect event it will render invalid event detail`() = runBlocking {
        robot.eventDetailUseCase.setData(null)

        viewModel.sendEvent(AppEvent.EventDetail(0))
        viewModel.eventUiState.test {
            assertTrue { expectMostRecentItem().detail == null }
        }
    }
}