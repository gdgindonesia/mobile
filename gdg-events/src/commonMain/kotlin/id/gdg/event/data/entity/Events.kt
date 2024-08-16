package id.gdg.event.data.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Events(
    @SerialName("pagination")
    val pagination: Pagination,

    @SerialName("results")
    val events: List<Event>,
)