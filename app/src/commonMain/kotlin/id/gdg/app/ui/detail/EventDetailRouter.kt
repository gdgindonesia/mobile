package id.gdg.app.ui.detail

import id.gdg.app.ui.Router
import kotlinx.serialization.Serializable

@Serializable
data class EventDetailRouter(val eventId: String) : Router