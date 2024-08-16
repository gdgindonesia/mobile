package id.gdg.event.data.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Pagination(
    @SerialName("current_page")
    val currentPage: Long,

    @SerialName("page_size")
    val pageSize: Long,
)