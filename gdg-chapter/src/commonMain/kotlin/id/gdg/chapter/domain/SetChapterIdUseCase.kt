package id.gdg.chapter.domain

import id.gdg.chapter.data.local.ChapterSelectionLocalStore

class SetChapterIdUseCase(private val chapterSelector: ChapterSelectionLocalStore) {

    suspend operator fun invoke(chapterId: Int) {
        chapterSelector.setChapterId(chapterId)
    }
}