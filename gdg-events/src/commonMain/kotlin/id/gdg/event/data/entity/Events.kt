package id.gdg.event.data.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Events(
    @SerialName("pagination")
    val pagination: Pagination,

    @SerialName("results")
    val events: List<Event>,
) {

    @Serializable
    data class Pagination(
        @SerialName("current_page")
        val currentPage: Long,

        @SerialName("page_size")
        val pageSize: Long,
    )

    @Serializable
    data class Event(
        @SerialName("id")
        val id: Long,

        @SerialName("title")
        val title: String,

        @SerialName("agenda")
        val agenda: String,

        @SerialName("allow_new_agenda")
        val allowNewAgenda: Boolean,

        @SerialName("audience_type")
        val audienceType: String,

        @SerialName("banner")
        val banner: String?,

        @SerialName("chapter_title")
        val chapterTitle: String,

        @SerialName("cropped_banner_url")
        val croppedBannerUrl: String,

        @SerialName("cropped_picture_url")
        val croppedPictureUrl: String,

        @SerialName("custom_tickets_url")
        val customTicketsUrl: String?,

        @SerialName("description")
        val description: String,

        @SerialName("description_short")
        val descriptionShort: String,

        @SerialName("end_date")
        val endDate: String,

        @SerialName("event_timezone")
        val eventTimezone: String,

        @SerialName("is_hidden")
        val isHidden: Boolean,

        @SerialName("is_virtual_event")
        val isVirtualEvent: Boolean,

        @SerialName("join_virtual_event_url")
        val joinVirtualEventUrl: String,

        @SerialName("picture")
        val picture: String,

        @SerialName("registration_required")
        val registrationRequired: Boolean,

        @SerialName("sharing_disabled")
        val sharingDisabled: Boolean,

        @SerialName("show_map")
        val showMap: Boolean,

        @SerialName("start_date")
        val startDate: String,

        @SerialName("static_url")
        val staticUrl: String,

        @SerialName("timezone_abbreviation")
        val timezoneAbbreviation: String,
    )
}