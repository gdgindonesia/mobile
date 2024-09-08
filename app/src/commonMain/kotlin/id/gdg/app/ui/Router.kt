package id.gdg.app.ui

import kotlinx.serialization.Serializable

sealed interface Router

@Serializable
data object SplashScreenRouter : Router

@Serializable
data object OnboardingRouter : Router

@Serializable
data object HomeRouter : Router

@Serializable
data class EventDetailRouter(val eventId: String) : Router