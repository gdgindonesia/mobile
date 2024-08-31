package id.gdg.app.ui.state

import id.gdg.chapter.model.ChapterModel

data class ChapterUiModel(
    val selectedChapterId: Int,
    val chapters: List<ChapterModel>
) {

    companion object {
        val Default get() = ChapterUiModel(
            selectedChapterId = -1,
            chapters = listOf()
        )
    }
}