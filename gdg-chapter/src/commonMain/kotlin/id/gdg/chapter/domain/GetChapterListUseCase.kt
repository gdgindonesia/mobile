package id.gdg.chapter.domain

import id.gdg.chapter.data.entity.Chapter
import id.gdg.chapter.model.ChapterModel

interface GetChapterListUseCase {

    operator fun invoke(): List<ChapterModel>
}

class GetChapterListUseCaseImpl : GetChapterListUseCase {

    override operator fun invoke() = chapterList()
        .map { ChapterModel(it.id, absoluteChapterName(it.name)) }

    private fun absoluteChapterName(city: String) = "GDG $city"

    /**
     * A list of GDG chapters in Indonesia.
     *
     * This list contains the ID of each chapter on the Bevy platform. You can use these IDs to query
     * information about a chapter, such as details, upcoming events, or past events.
     */
    private fun chapterList(): List<Chapter> {
        return listOf(
            Chapter(540, "Bali"),
            Chapter(577, "Jogjakarta"),
            Chapter(642, "Jakarta"),
            Chapter(681, "Bogor"),
            Chapter(694, "Surabaya"),
            Chapter(710, "Bandung"),
            Chapter(711, "Depok"),
            Chapter(712, "Semarang"),
            Chapter(1053, "Makassar"),
            Chapter(1332, "Medan"),
            Chapter(76, "Cloud Surabaya"),
            Chapter(137, "Cloud Bandung"),
            Chapter(1158, "Cloud Jakarta"),
        )
    }
}