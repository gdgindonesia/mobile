package id.gdg.app.di

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import id.gdg.app.AppViewModel
import id.gdg.chapter.domain.GetChapterListUseCase
import id.gdg.event.domain.GetHighlightPreviousEventUseCase
import id.gdg.event.domain.GetUpComingEventUseCase
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

object ViewModelFactory : KoinComponent {

    private val chapterListUseCase: GetChapterListUseCase by inject()
    private val upComingEventUseCase: GetUpComingEventUseCase by inject()
    private val highlightPreviousEventUseCase: GetHighlightPreviousEventUseCase by inject()

    @Composable
    fun create() = viewModel {
        AppViewModel(
            chapterListUseCase,
            upComingEventUseCase,
            highlightPreviousEventUseCase
        )
    }
}