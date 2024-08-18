package id.gdg.app.di

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import id.gdg.app.AppViewModel
import id.gdg.chapter.domain.GetChapterIdUseCase
import id.gdg.chapter.domain.GetChapterListUseCase
import id.gdg.chapter.domain.SetChapterIdUseCase
import id.gdg.event.domain.GetEventDetailUseCase
import id.gdg.event.domain.GetEventsUseCase
import id.gdg.event.domain.GetPreviousEventUseCase
import id.gdg.event.domain.GetUpComingEventUseCase
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

object ViewModelFactory : KoinComponent {

    // Chapters
    private val chapterListUseCase: GetChapterListUseCase by inject()
    private val getCurrentChapterUseCase: GetChapterIdUseCase by inject()
    private val setCurrentChapterUseCase: SetChapterIdUseCase by inject()

    // Events
    private val eventsUseCase: GetEventsUseCase by inject()

    @Composable
    fun create() = viewModel {
        AppViewModel(
            chapterListUseCase,
            getCurrentChapterUseCase,
            setCurrentChapterUseCase,
            eventsUseCase
        )
    }
}