package id.gdg.app.ui

sealed class AppEvent {

    data class ChangeChapterId(val chapterId: Int) : AppEvent()

    data object InitialContent : AppEvent()
    data object FetchPreviousEvent : AppEvent()
    data object FetchUpcomingEvent : AppEvent()

    data class EventDetail(val eventId: Int) : AppEvent()
}