package id.gdg.app.ui.state

sealed class AppEvent {

    data class EventDetail(val eventId: Int) : AppEvent()
    data class ChangeChapterId(val chapterId: Int) : AppEvent()
}