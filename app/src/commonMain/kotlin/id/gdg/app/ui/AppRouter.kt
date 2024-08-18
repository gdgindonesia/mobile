package id.gdg.app.ui

sealed class AppRouter(val route: String) {

    data object Splash : AppRouter("splash")
    data object Onboarding : AppRouter("onboarding")
    data object Home : AppRouter("home")
}