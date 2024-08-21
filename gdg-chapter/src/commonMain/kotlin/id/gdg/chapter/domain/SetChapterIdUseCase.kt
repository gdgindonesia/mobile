package id.gdg.chapter.domain

import id.gdg.chapter.data.local.ChapterSelectionLocalStore

interface SetChapterIdUseCase {

    suspend operator fun invoke(chapterId: Int)
}

class SetChapterIdUseCaseImpl(
    private val chapterSelector: ChapterSelectionLocalStore
) : SetChapterIdUseCase {

    override suspend operator fun invoke(chapterId: Int) {
        chapterSelector.setChapterId(chapterId)
    }
}