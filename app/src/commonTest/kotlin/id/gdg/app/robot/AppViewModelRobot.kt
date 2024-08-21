package id.gdg.app.robot

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import id.gdg.app.AppViewModel
import id.gdg.app.di.appModule
import id.gdg.app.stub.ChapterSelectionLocalStoreStub
import id.gdg.app.stub.GetChapterListUseCaseStub
import id.gdg.app.stub.GetEventDetailUseCaseStub
import id.gdg.app.stub.GetPreviousEventUseCaseStub
import id.gdg.app.stub.GetUpcomingEventUseCaseStub
import id.gdg.chapter.domain.GetChapterIdUseCaseImpl
import id.gdg.chapter.domain.SetChapterIdUseCaseImpl
import id.gdg.event.model.EventModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import okio.Path.Companion.toPath
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.dsl.module
import org.koin.test.KoinTest

@OptIn(ExperimentalCoroutinesApi::class)
object AppViewModelRobot : KoinTest {

    val testDispatcher = UnconfinedTestDispatcher()
    val testScope = TestScope(testDispatcher + Job())

    val localStore = ChapterSelectionLocalStoreStub()

    private val setCurrentChapterUseCase by lazy { SetChapterIdUseCaseImpl(localStore) }
    private val getCurrentChapterUseCase by lazy { GetChapterIdUseCaseImpl(localStore) }

    val chapterListUseCase = GetChapterListUseCaseStub()
    val previousEventUseCase = GetPreviousEventUseCaseStub()
    val upcomingEventUseCase = GetUpcomingEventUseCaseStub()
    val eventDetailUseCase = GetEventDetailUseCaseStub()

    fun createViewModel() = AppViewModel(
        chapterListUseCase,
        getCurrentChapterUseCase,
        setCurrentChapterUseCase,
        upcomingEventUseCase,
        previousEventUseCase,
        eventDetailUseCase
    )

    fun setUp() {
        val dataStoreModule = module {
            single<DataStore<Preferences>> {
                PreferenceDataStoreFactory.createWithPath(
                    corruptionHandler = null,
                    migrations = emptyList(),
                    scope = testScope,
                    produceFile = { "gdg_chapter.preferences_pb".toPath() },
                )
            }
        }

        startKoin {
            modules(appModule + dataStoreModule)
        }
    }

    fun tearDown() {
        stopKoin()
        testScope.cancel()
    }

    fun createEvents() = listOf(
        EventModel(
            id = 0,
            title = "Event Foo",
            chapterTitle = "GDG Foo",
            descriptionShort = "Loren Ipsum",
            eventImageUrl = "https://sample.com/image.png",
            startDate = "",
            timezoneAbbreviation = "WIB"
        ),
        EventModel(
            id = 1,
            title = "Event Bar",
            chapterTitle = "GDG bar",
            descriptionShort = "Loren Ipsum",
            eventImageUrl = "https://sample.com/image.png",
            startDate = "",
            timezoneAbbreviation = "WIB"
        ),
        EventModel(
            id = 2,
            title = "Event Foo Bar",
            chapterTitle = "GDG bar",
            descriptionShort = "Loren Ipsum",
            eventImageUrl = "https://sample.com/image.png",
            startDate = "",
            timezoneAbbreviation = "WIB"
        )
    )
}