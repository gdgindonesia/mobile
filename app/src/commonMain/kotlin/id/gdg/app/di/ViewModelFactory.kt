package id.gdg.app.di

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import id.gdg.app.ui.main.MainViewModel
import id.gdg.app.ui.detail.EventDetailViewModel
import id.gdg.app.ui.onboarding.OnboardingViewModel
import id.gdg.chapter.domain.GetChapterIdUseCase
import id.gdg.chapter.domain.GetChapterListUseCase
import id.gdg.chapter.domain.SetChapterIdUseCase
import id.gdg.event.domain.GetEventDetailUseCase
import id.gdg.event.domain.GetPreviousEventUseCase
import id.gdg.event.domain.GetUpcomingEventUseCase
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

object ViewModelFactory : KoinComponent {

    // Chapters
    private val chapterListUseCase: GetChapterListUseCase by inject()
    private val getCurrentChapterUseCase: GetChapterIdUseCase by inject()
    private val setCurrentChapterUseCase: SetChapterIdUseCase by inject()

    // Events
    private val upComingEventUseCase: GetUpcomingEventUseCase by inject()
    private val previousEventUseCase: GetPreviousEventUseCase by inject()
    private val eventDetailUseCase: GetEventDetailUseCase by inject()

    @Composable
    fun onboardingViewModel() = viewModel {
        OnboardingViewModel(
            chapterListUseCase,
            setCurrentChapterUseCase
        )
    }

    @Composable
    fun mainViewModel() = viewModel {
        MainViewModel(
            getCurrentChapterUseCase,
            setCurrentChapterUseCase,
            upComingEventUseCase,
            previousEventUseCase
        )
    }
    @Composable
    fun eventDetailViewModel() = viewModel {
        EventDetailViewModel(eventDetailUseCase)
    }
}