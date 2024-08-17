package id.gdg.event.data.fake

import id.gdg.event.data.entity.Events.Event
import id.gdg.event.data.entity.Events.Pagination
import id.gdg.event.data.entity.Events

class EventFake : Faker() {

    override fun json(): String {
        return """
            {
              "links": {
                "next": "https://gdg.community.dev/api/event_slim/for_chapter/642?order=-start_date&page=2&page_size=3&status=Completed",
                "previous": null
              },
              "pagination": {
                "previous_page": null,
                "current_page": 1,
                "next_page": 2,
                "page_size": 500
              },
              "count": 96,
              "results": [
                {
                  "agenda": "{\"multiday\": false, \"any_descriptions\": false, \"empty\": true, \"days\": [{\"title\": \"\", \"agenda\": []}]}",
                  "allow_new_agenda": false,
                  "audience_type": "IN_PERSON",
                  "banner": "https://storage.googleapis.com/platform-data-goog/event_banners/IOExtended24-Bevy-chaper-banner-2560x650_ttqW2rx.png",
                  "chapter_title": "GDG Jakarta",
                  "cropped_banner_url": "https://res.cloudinary.com/startup-grind/image/upload/c_scale,w_2560/c_crop,h_640,w_2560,y_0.0_mul_h_sub_0.0_mul_640/c_crop,h_640,w_2560/c_fill,dpr_2.0,f_auto,g_center,q_auto:good/v1/gcs/platform-data-goog/event_banners/IOExtended24-Bevy-chaper-banner-2560x650_ttqW2rx.png",
                  "cropped_picture_url": "https://res.cloudinary.com/startup-grind/image/upload/c_fill,w_500,h_500,g_center/c_fill,dpr_2.0,f_auto,g_center,q_auto:good/v1/gcs/platform-data-goog/events/Copy%20of%20IO%20extended%202024%20Bevy%20thumbnail%20with%20editable%20location_nSINYf7.png",
                  "custom_tickets_url": "",
                  "description": "\u003Cp\u003EBuild your first AI app with KMP and Compose Multiplatform using Gemini\u003Cbr\u003E\u003Cbr\u003EGoogle I/O connects developers worldwide for thoughtful discussions, hands-on learning with Google experts, and the first look at Google’s latest developer products. The magic of I/O doesn’t end after the main event. Local developers come together for I/O Extended events to discuss the latest new technologies, summarize content, host Q&amp;As, and meet other technology enthusiasts.\u003C/p\u003E\u003Cp\u003EIn Google I/O Extended 2024 Jakarta, we will have discussions on a range of topics; such as What's new for Web Technologies, What's new for Android, Flutter, Cloud, Web, and Google Developer Startup Program from the experts in the field.\u003C/p\u003E\u003Cp\u003EThank you, and see you in-person!\u003Cbr\u003E\u003Cbr\u003E\u003C/p\u003E\u003Cp\u003ENote: This workshop require you to bring laptop and programming level of experience.\u003C/p\u003E",
                  "description_short": "Google I/O connects developers worldwide for thoughtful discussions, hands-on learning with Google experts, and the first look at Google’s latest developer products. The magic of I/O doesn’t end after the main event. Local developers come together for I/O Extended events to discuss the latest new technologies, summarize content, host Q&As, and meet other technology enthusiasts.",
                  "end_date": "2024-06-30T09:00:00Z",
                  "event_timezone": "Asia/Jakarta",
                  "id": 68277,
                  "is_hidden": false,
                  "is_virtual_event": true,
                  "join_virtual_event_url": "https://gdg.community.dev/j/9u93qnm6kkeef/",
                  "picture": "https://res.cloudinary.com/startup-grind/image/upload/c_fill,dpr_2.0,f_auto,g_center,q_auto:good/v1/gcs/platform-data-goog/events/Copy%20of%20IO%20extended%202024%20Bevy%20thumbnail%20with%20editable%20location_nSINYf7.png",
                  "registration_required": true,
                  "sharing_disabled": false,
                  "show_map": true,
                  "start_date": "2024-06-30T06:00:00Z",
                  "static_url": "https://gdg.community.dev/e/my8vvf/",
                  "timezone_abbreviation": "WIB",
                  "title": "[IOX 24 JKT - Workshop] Build your first AI using Gemini"
                },
                {
                  "agenda": "{\"multiday\": false, \"any_descriptions\": false, \"empty\": true, \"days\": [{\"title\": \"\", \"agenda\": []}]}",
                  "allow_new_agenda": false,
                  "audience_type": "IN_PERSON",
                  "banner": "https://storage.googleapis.com/platform-data-goog/event_banners/IOExtended24-Bevy-chaper-banner-2560x650_m1OCWpF.png",
                  "chapter_title": "GDG Jakarta",
                  "cropped_banner_url": "https://res.cloudinary.com/startup-grind/image/upload/c_scale,w_2560/c_crop,h_640,w_2560,y_0.0_mul_h_sub_0.0_mul_640/c_crop,h_640,w_2560/c_fill,dpr_2.0,f_auto,g_center,q_auto:good/v1/gcs/platform-data-goog/event_banners/IOExtended24-Bevy-chaper-banner-2560x650_m1OCWpF.png",
                  "cropped_picture_url": "https://res.cloudinary.com/startup-grind/image/upload/c_fill,w_500,h_500,g_center/c_fill,dpr_2.0,f_auto,g_center,q_auto:good/v1/gcs/platform-data-goog/events/bevy%20logo%20jkt.jpeg",
                  "custom_tickets_url": "",
                  "description": "\u003Cp\u003E[IOX 24 JKT - Workshop] Keras 101: Model Building, Optimization, and Integration\u003Cbr\u003E\u003Cbr\u003EGoogle I/O connects developers worldwide for thoughtful discussions, hands-on learning with Google experts, and the first look at Google’s latest developer products. The magic of I/O doesn’t end after the main event. Local developers come together for I/O Extended events to discuss the latest new technologies, summarize content, host Q&amp;As, and meet other technology enthusiasts.\u003C/p\u003E\u003Cp\u003EIn Google I/O Extended 2024 Jakarta, we will have discussions on a range of topics; such as What's new for Web Technologies, What's new for Android, Flutter, Cloud, Web, and Google Developer Startup Program from the experts in the field.\u003C/p\u003E\u003Cp\u003EThank you, and see you in-person!\u003Cbr\u003E\u003C/p\u003E\u003Cp\u003ENote: This workshop require you to bring laptop and programming level of experience.\u003C/p\u003E",
                  "description_short": "Google I/O connects developers worldwide for thoughtful discussions, hands-on learning with Google experts, and the first look at Google’s latest developer products. The magic of I/O doesn’t end after the main event. Local developers come together for I/O Extended events to discuss the latest new technologies, summarize content, host Q&As, and meet other technology enthusiasts.",
                  "end_date": "2024-06-30T09:00:00Z",
                  "event_timezone": "Asia/Jakarta",
                  "id": 68245,
                  "is_hidden": false,
                  "is_virtual_event": true,
                  "join_virtual_event_url": "https://gdg.community.dev/j/99cv9ku6buw3d/",
                  "picture": "https://res.cloudinary.com/startup-grind/image/upload/c_fill,dpr_2.0,f_auto,g_center,q_auto:good/v1/gcs/platform-data-goog/events/bevy%20logo%20jkt.jpeg",
                  "registration_required": true,
                  "sharing_disabled": false,
                  "show_map": true,
                  "start_date": "2024-06-30T06:00:00Z",
                  "static_url": "https://gdg.community.dev/e/mymw9d/",
                  "timezone_abbreviation": "WIB",
                  "title": "[IOX 24 JKT - Workshop] Keras 101: Model Building, Optimization, and Integration"
                },
                {
                  "agenda": "{\"multiday\": false, \"any_descriptions\": false, \"empty\": true, \"days\": [{\"title\": \"\", \"agenda\": []}]}",
                  "allow_new_agenda": false,
                  "audience_type": "IN_PERSON",
                  "banner": "https://storage.googleapis.com/platform-data-goog/event_banners/IOExtended24-Bevy-chaper-banner-2560x650_P9Gltfm.png",
                  "chapter_title": "GDG Jakarta",
                  "cropped_banner_url": "https://res.cloudinary.com/startup-grind/image/upload/c_scale,w_2560/c_crop,h_640,w_2560,y_0.0_mul_h_sub_0.0_mul_640/c_crop,h_640,w_2560/c_fill,dpr_2.0,f_auto,g_center,q_auto:good/v1/gcs/platform-data-goog/event_banners/IOExtended24-Bevy-chaper-banner-2560x650_P9Gltfm.png",
                  "cropped_picture_url": "https://res.cloudinary.com/startup-grind/image/upload/c_fill,w_500,h_500,g_center/c_fill,dpr_2.0,f_auto,g_center,q_auto:good/v1/gcs/platform-data-goog/events/Copy%20of%20IO%20extended%202024%20Bevy%20thumbnail%20with%20editable%20location_WDIEiO2.png",
                  "custom_tickets_url": "",
                  "description": "\u003Cp\u003ENext-Gen AI Assistants Leveraging Vertex AI Agent Builder and Gemini AI: A Fresh Graduate's Journey\u003Cbr\u003E\u003Cbr\u003EGoogle I/O connects developers worldwide for thoughtful discussions, hands-on learning with Google experts, and the first look at Google’s latest developer products. The magic of I/O doesn’t end after the main event. Local developers come together for I/O Extended events to discuss the latest new technologies, summarize content, host Q&amp;As, and meet other technology enthusiasts.\u003C/p\u003E\u003Cp\u003EIn Google I/O Extended 2024 Jakarta, we will have discussions on a range of topics; such as What's new for Web Technologies, What's new for Android, Flutter, Cloud, Web, and Google Developer Startup Program from the experts in the field.\u003C/p\u003E\u003Cp\u003EThank you, and see you in-person!\u003Cbr\u003E\u003C/p\u003E\u003Cp\u003ENote: This workshop require you to bring laptop and programming level of experience.\u003C/p\u003E",
                  "description_short": "Google I/O connects developers worldwide for thoughtful discussions, hands-on learning with Google experts, and the first look at Google’s latest developer products. The magic of I/O doesn’t end after the main event. Local developers come together for I/O Extended events to discuss the latest new technologies, summarize content, host Q&As, and meet other technology enthusiasts.",
                  "end_date": "2024-06-30T05:00:00Z",
                  "event_timezone": "Asia/Jakarta",
                  "id": 68292,
                  "is_hidden": false,
                  "is_virtual_event": true,
                  "join_virtual_event_url": "https://gdg.community.dev/j/jr2sak3w3f3zn/",
                  "picture": "https://res.cloudinary.com/startup-grind/image/upload/c_fill,dpr_2.0,f_auto,g_center,q_auto:good/v1/gcs/platform-data-goog/events/Copy%20of%20IO%20extended%202024%20Bevy%20thumbnail%20with%20editable%20location_WDIEiO2.png",
                  "registration_required": true,
                  "sharing_disabled": false,
                  "show_map": true,
                  "start_date": "2024-06-30T02:00:00Z",
                  "static_url": "https://gdg.community.dev/e/m69d8n/",
                  "timezone_abbreviation": "WIB",
                  "title": "[IOX 24 JKT - Workshop] Next-Gen AI Assistants"
                }
              ]
            }
        """.trimIndent()
    }
}