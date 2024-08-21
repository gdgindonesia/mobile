package id.gdg.app.stub

import id.gdg.chapter.domain.GetChapterListUseCase
import id.gdg.chapter.model.ChapterModel

class GetChapterListUseCaseStub : GetChapterListUseCase {

    private val _chapters = mutableListOf<ChapterModel>()

    fun setData(chapters: List<ChapterModel>) {
        _chapters.clear()
        _chapters.addAll(chapters)
    }

    override fun invoke() = _chapters
}