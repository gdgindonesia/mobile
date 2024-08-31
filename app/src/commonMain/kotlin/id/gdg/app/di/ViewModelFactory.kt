package id.gdg.app.di

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import id.gdg.app.AppViewModel
import id.gdg.app.update.ChapterEventUpdate
import id.gdg.app.update.ChapterUpdate
import id.gdg.app.update.EventDetailUpdate
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

object ViewModelFactory : KoinComponent {

    private val chapterUpdate: ChapterUpdate by inject()
    private val chapterEventUpdate: ChapterEventUpdate by inject()
    private val eventDetailUpdate: EventDetailUpdate by inject()

    @Composable
    fun create() = viewModel {
        AppViewModel(
            chapterUpdate,
            chapterEventUpdate,
            eventDetailUpdate
        )
    }
}