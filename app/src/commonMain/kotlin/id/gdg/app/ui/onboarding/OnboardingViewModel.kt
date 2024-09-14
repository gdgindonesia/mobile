package id.gdg.app.ui.onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.gdg.chapter.domain.GetChapterListUseCase
import id.gdg.chapter.domain.SetChapterIdUseCase
import kotlinx.coroutines.launch

class OnboardingViewModel(
    private val chapterListUseCase: GetChapterListUseCase,
    private val setCurrentChapterUseCase: SetChapterIdUseCase
) : ViewModel() {

    val chapterList get() = chapterListUseCase()

    fun setChapterId(id: Int) {
        viewModelScope.launch {
            setCurrentChapterUseCase(id)
        }
    }
}