package id.gdg.app.ui.state

sealed class AppEvent {

    /**
     * This event got triggered each app got opened.
     * We need to ensure that the onboarding screen only display once.
     */
    data object InitActiveChapterId : AppEvent()

    data object FetchEvent : AppEvent()
    data class SetActiveChapterId(val id: Int) : AppEvent()
}