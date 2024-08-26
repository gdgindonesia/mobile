package id.gdg.app.ui

import id.gdg.app.ui.state.EventDetailUiModel

sealed class AppRouter(val route: String) {

    data object Splash : AppRouter(SplashRoute)
    data object Onboarding : AppRouter(OnboardingRoute)
    data object Home : AppRouter(HomeRoute)

    data class EventDetail(val eventId: Int) : AppRouter(EventDetailRoute)

    companion object {
        val SplashRoute get() = "splash"
        val OnboardingRoute get() = "onboarding"

        val HomeRoute get() = "home"

        // SAMPAH
        val EventDetailRoute get() = "detail/{$ArgumentEventId}"
        fun constructEventDetailRoute(eventId: String) = EventDetailRoute
            .replace("{$ArgumentEventId}", eventId)

        val ArgumentEventId get() = "eventId"
    }
}