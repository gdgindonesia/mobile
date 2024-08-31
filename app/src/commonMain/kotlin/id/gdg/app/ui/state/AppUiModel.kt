package id.gdg.app.ui.state

data class AppUiModel(
    val eventUiState: EventChapterUiModel = EventChapterUiModel.Default,
    val chapterUiState: ChapterUiModel = ChapterUiModel.Default
)