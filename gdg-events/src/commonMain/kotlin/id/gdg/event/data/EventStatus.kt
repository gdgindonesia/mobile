package id.gdg.event.data

/**
 * An EventStatus query parameter.
 *
 * The Bevy platform uses two types to differentiate between upcoming and past events.
 * [Upcoming] uses "Live" to indicate that an event is upcoming, while [Previous]
 * represents an event that has already been held.
 */
sealed class EventStatus(val value: String) {
    data object Upcoming : EventStatus("Live")
    data object Previous : EventStatus("Completed")
}