package id.gdg.app.robot

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import id.gdg.app.AppViewModel
import id.gdg.app.common.UpdateScope
import id.gdg.app.update.ChapterEventUpdateImpl
import id.gdg.app.update.ChapterUpdateImpl
import id.gdg.app.update.EventDetailUpdateImpl
import id.gdg.app.stub.ChapterSelectionLocalStoreStub
import id.gdg.app.stub.GetChapterListUseCaseStub
import id.gdg.app.stub.GetEventDetailUseCaseStub
import id.gdg.app.stub.GetPreviousEventUseCaseStub
import id.gdg.app.stub.GetUpcomingEventUseCaseStub
import id.gdg.chapter.domain.GetChapterIdUseCaseImpl
import id.gdg.chapter.domain.SetChapterIdUseCaseImpl
import id.gdg.event.domain.mapper.AudienceType
import id.gdg.event.model.EventModel
import kotlinx.coroutines.CoroutineScope
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
    private val testScope = TestScope(testDispatcher + Job())

    /**
     * As the mockK haven't support for the Kotlin 2.0 yet,
     * we have to create a fake of the origin class to ensure we could
     * stub it easily.
     */
    val chapterListUseCase = GetChapterListUseCaseStub()
    val previousEventUseCase = GetPreviousEventUseCaseStub()
    val upcomingEventUseCase = GetUpcomingEventUseCaseStub()
    val eventDetailUseCase = GetEventDetailUseCaseStub()

    private val localStore = ChapterSelectionLocalStoreStub()

    val getCurrentChapterUseCase by lazy { GetChapterIdUseCaseImpl(localStore) }
    private val setCurrentChapterUseCase by lazy { SetChapterIdUseCaseImpl(localStore) }

    private val testUpdateScope by lazy {
        object : UpdateScope {
            override val scope: CoroutineScope
                get() = testScope

            override fun shouldUseViewModelScope(scope: CoroutineScope) = Unit
            override fun close() = Unit
        }
    }

    private val chapterUpdate by lazy {
        ChapterUpdateImpl(
            chapterListUseCase,
            getCurrentChapterUseCase,
            setCurrentChapterUseCase,
            testUpdateScope
        )
    }

    private val chapterEventUpdate by lazy {
        ChapterEventUpdateImpl(
            upcomingEventUseCase,
            previousEventUseCase,
            testUpdateScope
        )
    }

    private val eventDetailUpdate by lazy {
        EventDetailUpdateImpl(
            eventDetailUseCase,
            testUpdateScope
        )
    }

    fun createViewModel() = AppViewModel(
        chapterUpdate,
        chapterEventUpdate,
        eventDetailUpdate
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
            modules(dataStoreModule)
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
            timezoneAbbreviation = "WIB",
            audienceType = AudienceType("hybrid")
        ),
        EventModel(
            id = 1,
            title = "Event Bar",
            chapterTitle = "GDG bar",
            descriptionShort = "Loren Ipsum",
            eventImageUrl = "https://sample.com/image.png",
            startDate = "",
            timezoneAbbreviation = "WIB",
            audienceType = AudienceType("in person")
        ),
        EventModel(
            id = 2,
            title = "Event Foo Bar",
            chapterTitle = "GDG bar",
            descriptionShort = "Loren Ipsum",
            eventImageUrl = "https://sample.com/image.png",
            startDate = "",
            timezoneAbbreviation = "WIB",
            audienceType = AudienceType("online")
        )
    )
}