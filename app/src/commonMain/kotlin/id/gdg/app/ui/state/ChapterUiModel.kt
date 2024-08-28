package id.gdg.app.ui.state

import id.gdg.app.ui.state.partial.PreviousEventsUiModel
import id.gdg.app.ui.state.partial.UpcomingEventUiModel

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
