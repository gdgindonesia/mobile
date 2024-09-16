package id.gdg.event.data.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class EventDetail(

    @SerialName("agenda")
    val agenda: Agenda,

    @SerialName("allow_automated_emails_when_hidden")
    val allowAutomatedEmailsWhenHidden: Boolean,

    @SerialName("allows_cohosting")
    val allowsCohosting: Boolean,

    @SerialName("audience_type")
    val audienceType: String,

    @SerialName("banner")
    val banner: Banner,

    @SerialName("chapter")
    val chapter: Chapter,

    @SerialName("cohost_registration_url")
    val cohostRegistrationUrl: String,

    @SerialName("completed")
    val completed: Boolean,

    @SerialName("could_update_meetup")
    val couldUpdateMeetup: Boolean,

    @SerialName("cropped_banner_url")
    val croppedBannerUrl: String,

    @SerialName("currency")
    val currency: String,

    @SerialName("description")
    val description: String,

    @SerialName("description_short")
    val descriptionShort: String,

    @SerialName("discount_code_usable")
    val discountCodeUsable: DiscountCodeUsable,

    @SerialName("end_date")
    val endDate: String,

    @SerialName("end_date_iso")
    val endDateIso: String,

    @SerialName("end_date_naive")
    val endDateNaive: String,

    @SerialName("event_timezone")
    val eventTimezone: String,

    @SerialName("event_type")
    val eventType: Int,

    @SerialName("event_type_allow_new_agenda")
    val eventTypeAllowNewAgenda: Boolean,

    @SerialName("event_type_rsvp_only")
    val eventTypeRsvpOnly: Boolean,

    @SerialName("event_type_slug")
    val eventTypeSlug: String,

    @SerialName("event_type_title")
    val eventTypeTitle: String,

    @SerialName("event_wrapup_photos")
    val eventWrapupPhotos: List<EventWrapupPhoto>,

    @SerialName("eventbrite_url")
    val eventbriteUrl: String?,

    @SerialName("facebook_pixel")
    val facebookPixel: String,

    @SerialName("hide_agenda_on_event_page")
    val hideAgendaOnEventPage: Boolean,

    @SerialName("hide_location")
    val hideLocation: Boolean,

    @SerialName("id")
    val id: Int,

    @SerialName("internal_payment_support")
    val internalPaymentSupport: Boolean,

    @SerialName("is_hidden")
    val isHidden: Boolean,

    @SerialName("is_test")
    val isTest: Boolean,

    @SerialName("is_virtual_event")
    val isVirtualEvent: Boolean,

    @SerialName("lobby")
    val lobby: Lobby,

    @SerialName("media_partners")
    val mediaPartners: List<Int>,

    @SerialName("mobile_relative_event_type")
    val mobileRelativeEventType: String,

    @SerialName("moderators")
    val moderators: List<Person>,

    @SerialName("network_segment_max_capacity")
    val networkSegmentMaxCapacity: Int,

    @SerialName("panelists")
    val panelists: List<Person>,

    @SerialName("partners_list")
    val partnersList: List<Partners>,

    @SerialName("payment_processor_slug")
    val paymentProcessorSlug: String,

    @SerialName("picture")
    val picture: Picture,

    @SerialName("registration_required")
    val registrationRequired: Boolean,

    @SerialName("relative_url")
    val relativeUrl: String,

    @SerialName("sharing_disabled")
    val sharingDisabled: Boolean,

    @SerialName("short_id")
    val shortId: String,

    @SerialName("show_map")
    val showMap: Boolean,

    @SerialName("show_short_description_on_event_banner")
    val showShortDescriptionOnEventBanner: Boolean,

    @SerialName("slug")
    val slug: String,

    @SerialName("speakers")
    val speakers: List<Person>,

    @SerialName("start_date")
    val startDate: String,

    @SerialName("start_date_iso")
    val startDateIso: String,

    @SerialName("start_date_naive")
    val startDateNaive: String,

    @SerialName("static_url")
    val staticUrl: String,

    @SerialName("status")
    val status: String,

    @SerialName("tags")
    val tags: List<String>,

    @SerialName("tickets")
    val tickets: List<Ticket>,

    @SerialName("_timezone")
    val timezone: String,

    @SerialName("timezone_abbreviation")
    val timezoneAbbreviation: String,

    @SerialName("title")
    val title: String,

    @SerialName("total_attendees")
    val totalAttendees: Int,

    @SerialName("url")
    val url: String,

    @SerialName("use_external_ticketing")
    val useExternalTicketing: Boolean,

    @SerialName("use_featured_attendees")
    val useFeaturedAttendees: Boolean,

    @SerialName("venue_address")
    val venueAddress: String? = "",

    @SerialName("venue_city")
    val venueCity: String? = "",

    @SerialName("venue_name")
    val venueName: String? = "",

    @SerialName("venue_zip_code")
    val venueZipCode: String? = "",

    @SerialName("video_url")
    val videoUrl: String?,

    @SerialName("visible_on_parent_chapter_only")
    val visibleOnParentChapterOnly: Boolean
) {
    @Serializable
    data class Agenda(

        @SerialName("any_descriptions")
        val anyDescriptions: Boolean,

        @SerialName("days")
        val days: List<Day>,

        @SerialName("empty")
        val empty: Boolean,

        @SerialName("multiday")
        val multiday: Boolean
    ) {
        @Serializable
        data class Day(

            @SerialName("agenda")
            val agenda: List<Agenda>,

            @SerialName("title")
            val title: String
        ) {
            @Serializable
            data class Agenda(

                @SerialName("activity")
                val activity: String,

                @SerialName("audience_type")
                val audienceType: String,

                @SerialName("description")
                val description: String,

                @SerialName("time")
                val time: String
            )
        }
    }

    @Serializable
    data class Banner(

        @SerialName("path")
        val path: String,

        @SerialName("thumbnail_format")
        val thumbnailFormat: String,

        @SerialName("thumbnail_height")
        val thumbnailHeight: Int,

        @SerialName("thumbnail_url")
        val thumbnailUrl: String,

        @SerialName("thumbnail_width")
        val thumbnailWidth: Int,

        @SerialName("url")
        val url: String
    )

    @Serializable
    data class Chapter(

        @SerialName("chapter_location")
        val chapterLocation: String,

        @SerialName("city")
        val city: String,

        @SerialName("country")
        val country: String,

        @SerialName("country_name")
        val countryName: String,

        @SerialName("description")
        val description: String,

        @SerialName("hide_country_info")
        val hideCountryInfo: Boolean,

        @SerialName("id")
        val id: Int,

        @SerialName("relative_url")
        val relativeUrl: String,

        @SerialName("state")
        val state: String,

        @SerialName("timezone")
        val timezone: String,

        @SerialName("title")
        val title: String,

        @SerialName("url")
        val url: String
    )

    @Serializable
    data class DiscountCodeUsable(

        @SerialName("detail")
        val detail: String,

        @SerialName("value")
        val value: Boolean
    )

    @Serializable
    data class EventWrapupPhoto(

        @SerialName("id")
        val id: Int,

        @SerialName("order")
        val order: Int,

        @SerialName("picture")
        val picture: Picture
    )

    @Serializable
    data class Lobby(

        @SerialName("banner")
        val banner: Banner,

        @SerialName("event")
        val event: Int,

        @SerialName("external_video_url")
        val externalVideoUrl: String,

        @SerialName("message")
        val message: String,

        @SerialName("video_type")
        val videoType: String,

        @SerialName("video_url")
        val videoUrl: String
    ) {
        @Serializable
        class Banner
    }

    @Serializable
    data class Partners(

        @SerialName("company")
        val company: String,

        @SerialName("description")
        val description: String,

        @SerialName("event_sponsor_id")
        val eventSponsorId: Int,

        @SerialName("id")
        val id: Int,

        @SerialName("is_global")
        val isGlobal: Boolean,

        @SerialName("logo")
        val logo: Logo,

        @SerialName("url")
        val url: String,

        @SerialName("visible")
        val visible: Boolean
    ) {
        @Serializable
        data class Logo(

            @SerialName("path")
            val path: String,

            @SerialName("thumbnail_format")
            val thumbnailFormat: String,

            @SerialName("thumbnail_height")
            val thumbnailHeight: Int,

            @SerialName("thumbnail_url")
            val thumbnailUrl: String,

            @SerialName("thumbnail_width")
            val thumbnailWidth: Int,

            @SerialName("url")
            val url: String
        )
    }

    @Serializable
    data class Ticket(

        @SerialName("attendee_count")
        val attendeeCount: Int,

        @SerialName("audience_type")
        val audienceType: String,

        @SerialName("available")
        val available: Int,

        @SerialName("can_delete")
        val canDelete: Boolean,

        @SerialName("currency")
        val currency: String,

        @SerialName("description")
        val description: String,

        @SerialName("discount_code")
        val discountCode: String,

        @SerialName("event")
        val event: Int,

        @SerialName("id")
        val id: Int,

        @SerialName("title")
        val title: String,

        @SerialName("total_count")
        val totalCount: Int,

        @SerialName("visible")
        val visible: Boolean,

        @SerialName("waitlist_count")
        val waitlistCount: Int,

        @SerialName("waitlist_enabled")
        val waitlistEnabled: Boolean
    )

    @Serializable
    data class Person(

        @SerialName("bio")
        val bio: String,

        @SerialName("company")
        val company: String,

        @SerialName("company_twitter")
        val companyTwitter: String,

        @SerialName("event_person_id")
        val eventPersonId: Int,

        @SerialName("first_name")
        val firstName: String,

        @SerialName("id")
        val id: Int,

        @SerialName("last_name")
        val lastName: String,

        @SerialName("personal_twitter")
        val personalTwitter: String,

        @SerialName("picture")
        val picture: Picture?,

        @SerialName("title")
        val title: String
    )

    @Serializable
    data class Picture(

        @SerialName("path")
        val path: String? = null,

        @SerialName("thumbnail_format")
        val thumbnailFormat: String? = null,

        @SerialName("thumbnail_height")
        val thumbnailHeight: Int? = null,

        @SerialName("thumbnail_url")
        val thumbnailUrl: String? = null,

        @SerialName("thumbnail_width")
        val thumbnailWidth: Int? = null,

        @SerialName("url")
        val url: String? = null
    )
}