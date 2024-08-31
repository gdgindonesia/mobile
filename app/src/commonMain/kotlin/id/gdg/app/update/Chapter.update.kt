package id.gdg.app.update

import id.gdg.app.common.Update
import id.gdg.app.common.UpdateScope
import id.gdg.app.ui.AppEvent
import id.gdg.app.ui.state.ChapterUiModel
import id.gdg.chapter.domain.GetChapterIdUseCase
import id.gdg.chapter.domain.GetChapterListUseCase
import id.gdg.chapter.domain.SetChapterIdUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

interface ChapterUpdate : Update {

    val chapterUiState: Flow<ChapterUiModel>
}

class ChapterUpdateImpl(
    private val chapterListUseCase: GetChapterListUseCase,
    private val getCurrentChapterUseCase: GetChapterIdUseCase,
    private val setCurrentChapterUseCase: SetChapterIdUseCase,
    private val updateScope: UpdateScope,
) : ChapterUpdate, UpdateScope by updateScope {

    override val chapterUiState: Flow<ChapterUiModel>
        get() = getCurrentChapterUseCase().map {
            ChapterUiModel(
                selectedChapterId = it ?: Int.MIN_VALUE,
                chapters = chapterListUseCase()
            )
        }.flowOn(Dispatchers.Default)

    override fun handleEvent(event: AppEvent) {
        if (event is AppEvent.ChangeChapterId) {
            shouldChangeCurrentChapterId(event.chapterId)
        }
    }

    private fun shouldChangeCurrentChapterId(chapterId: Int) {
        scope.launch {
            setCurrentChapterUseCase(chapterId)
        }
    }
}