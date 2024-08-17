package id.gdg.event.data.fake

import id.gdg.event.data.entity.Event
import id.gdg.event.data.entity.Events
import id.gdg.event.data.entity.Pagination

fun eventFake(): Events {
    return Events(
        pagination = Pagination(
            currentPage = 0,
            pageSize = 1
        ),
        events = listOf(
            Event(
                id = 1,
                title = "DevFest",
                agenda = "",
                allowNewAgenda = false,
                audienceType = "IN_PERSON",
                banner = null,
                chapterTitle = "GDG Foobar",
                croppedBannerUrl = "https://test.com/sample.png",
                croppedPictureUrl = "https://test.com/sample.png",
                customTicketsUrl = "",
                description = "Loren Ipsum",
                descriptionShort = "Loren",
                endDate = "2024-06-30T09:00:00Z",
                eventTimezone = "Asia/Jakarta",
                isHidden = false,
                isVirtualEvent = true,
                joinVirtualEventUrl = "",
                picture = "",
                registrationRequired = true,
                sharingDisabled = false,
                showMap = true,
                startDate = "2024-06-30T06:00:00Z",
                staticUrl = "",
                timezoneAbbreviation = "WIB"
            ),
            Event(
                id = 2,
                title = "DevFest",
                agenda = "",
                allowNewAgenda = false,
                audienceType = "IN_PERSON",
                banner = null,
                chapterTitle = "GDG Foobar",
                croppedBannerUrl = "https://test.com/sample.png",
                croppedPictureUrl = "https://test.com/sample.png",
                customTicketsUrl = "",
                description = "Loren Ipsum",
                descriptionShort = "Loren",
                endDate = "2024-06-30T09:00:00Z",
                eventTimezone = "Asia/Jakarta",
                isHidden = false,
                isVirtualEvent = true,
                joinVirtualEventUrl = "",
                picture = "",
                registrationRequired = true,
                sharingDisabled = false,
                showMap = true,
                startDate = "2024-06-30T06:00:00Z",
                staticUrl = "",
                timezoneAbbreviation = "WIB"
            ),
            Event(
                id = 3,
                title = "DevFest",
                agenda = "",
                allowNewAgenda = false,
                audienceType = "IN_PERSON",
                banner = null,
                chapterTitle = "GDG Foobar",
                croppedBannerUrl = "https://test.com/sample.png",
                croppedPictureUrl = "https://test.com/sample.png",
                customTicketsUrl = "",
                description = "Loren Ipsum",
                descriptionShort = "Loren",
                endDate = "2024-06-30T09:00:00Z",
                eventTimezone = "Asia/Jakarta",
                isHidden = false,
                isVirtualEvent = true,
                joinVirtualEventUrl = "",
                picture = "",
                registrationRequired = true,
                sharingDisabled = false,
                showMap = true,
                startDate = "2024-06-30T06:00:00Z",
                staticUrl = "",
                timezoneAbbreviation = "WIB"
            )
        )
    )
}