package id.gdg.app.ui.main.state

data class ChapterUiModel(
    val upcomingEvent: UpcomingEventUiModel,
    val previousEvents: PreviousEventsUiModel
) {

    companion object {
        val Default get() = ChapterUiModel(
            upcomingEvent = UpcomingEventUiModel.Empty,
            previousEvents = PreviousEventsUiModel.Empty
        )
    }
}
