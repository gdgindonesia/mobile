package id.gdg.chapter.domain

import id.gdg.chapter.data.local.ChapterSelectionLocalStore
import kotlinx.coroutines.flow.Flow

class GetChapterIdUseCase(private val chapterSelector: ChapterSelectionLocalStore) {

    operator fun invoke(): Flow<Int?> {
        return chapterSelector.getCurrentChapterId()
    }
}