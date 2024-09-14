package id.gdg.app.ui.main

sealed class MainEvent {

    data class ChangeChapterId(val chapterId: Int) : MainEvent()

    data object InitialContent : MainEvent()

    data object FetchPreviousEvent : MainEvent()
    data object FetchUpcomingEvent : MainEvent()
}