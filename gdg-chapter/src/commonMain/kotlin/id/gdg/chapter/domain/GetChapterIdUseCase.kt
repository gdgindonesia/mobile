package id.gdg.chapter.domain

import id.gdg.chapter.data.local.ChapterSelectionLocalStore
import kotlinx.coroutines.flow.Flow

interface GetChapterIdUseCase {

    operator fun invoke(): Flow<Int?>
}

class GetChapterIdUseCaseImpl(
    private val chapterSelector: ChapterSelectionLocalStore
) : GetChapterIdUseCase {

    override operator fun invoke(): Flow<Int?> {
        return chapterSelector.getCurrentChapterId()
    }
}