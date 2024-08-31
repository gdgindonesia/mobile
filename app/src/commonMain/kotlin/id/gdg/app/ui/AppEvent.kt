package id.gdg.app.ui

sealed interface AppEvent {

    data class ChangeChapterId(val chapterId: Int) : AppEvent

    data class FetchPreviousEvent(val chapterId: Int) : AppEvent
    data class FetchUpcomingEvent(val chapterId: Int) : AppEvent

    data class EventDetail(val eventId: Int) : AppEvent
}