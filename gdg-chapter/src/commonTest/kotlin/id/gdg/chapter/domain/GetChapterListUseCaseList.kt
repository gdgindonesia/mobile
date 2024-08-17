package id.gdg.chapter.domain

import id.gdg.chapter.model.ChapterModel
import kotlin.test.Test
import kotlin.test.assertEquals

class GetChapterListUseCaseList {

    @Test
    fun `invoked should return a list of ChapterModel with absolute chapter`() {
        val useCase = GetChapterListUseCase()
        val expected = listOf(
            ChapterModel(540, "GDG Bali"),
            ChapterModel(577, "GDG Jogjakarta"),
            ChapterModel(642, "GDG Jakarta"),
            ChapterModel(681, "GDG Bogor"),
            ChapterModel(694, "GDG Surabaya"),
            ChapterModel(710, "GDG Bandung"),
            ChapterModel(711, "GDG Depok"),
            ChapterModel(712, "GDG Semarang"),
            ChapterModel(1053, "GDG Makassar"),
            ChapterModel(1332, "GDG Medan")
        )

        assertEquals(expected, useCase())
    }
}