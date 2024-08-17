package id.gdg.event.data.fake

import id.gdg.event.data.entity.EventDetail
import kotlinx.serialization.json.Json

class EventDetailFake : Faker() {

    companion object {
        const val EVENT_DETAIL_ID = 60014
    }

    override fun json(): String {
        return """
            {
          "id": "$EVENT_DETAIL_ID",
          "title": "DevFest Jakarta 2023",
          "audience_type": "HYBRID",
          "speaker": null,
          "speaker_twitter": null,
          "company": null,
          "company_twitter": null,
          "description_short": "DevFests are community-driven tech conferences hosted by Google Developer Groups (GDGs) around the world. They feature talks, hands-on demos, workshops, and codelabs on the latest Google tech. In 2022, over 550 DevFests helped over 320,000 developers learn about Google's latest technologies from Googlers, Google Developer Experts, and speakers from the industry.",
          "show_short_description_on_event_banner": true,
          "description": "\u003Cp\u003E\u003Cb\u003EDevFest \u003C/b\u003Eis a local tech conference hosted by \u003Cb\u003EGoogle Developer Groups (GDGs)\u003C/b\u003E around the world. It's a great opportunity for developers of all skill levels to learn about the latest Google technologies, meet other developers, and share their own knowledge.\u003C/p\u003E\u003Cp\u003E\u003Cb\u003EDevFest \u003C/b\u003Eevents feature a variety of activities, including:\u003C/p\u003E\u003Cul\u003E\u003Cli\u003ETalks by experts on a variety of Google technologies\u003C/li\u003E\u003Cli\u003ENetworking opportunities with other developers\u003C/li\u003E\u003C/ul\u003E\u003Cp\u003E\u003Cb\u003EDevFest \u003C/b\u003Eis a great way to stay up-to-date on the latest Google technologies, connect with other developers, and learn new skills. It's also a lot of fun!&nbsp;\u003Cspan style=\"\"\u003EIn 2023, \u003Cb\u003EDevFest Jakarta\u003C/b\u003E will be an in-person event, giving developers the chance to connect with each other face-to-face. It's a global moment that empowers developers to teach, learn, and connect when they may need it the most.\u003Cbr\u003E\u003C/span\u003E\u003C/p\u003E\u003Cp\u003E\u003Cb\u003EThank you, and see you in person!\u003C/b\u003E\u003C/p\u003E",
          "picture": {
            "url": "https://res.cloudinary.com/startup-grind/image/upload/c_fill,dpr_2,f_auto,g_center,q_auto:good/v1/gcs/platform-data-goog/events/DF23-Bevy-EventThumb-Blue_IvFpxKH.png",
            "path": "events/DF23-Bevy-EventThumb-Blue_IvFpxKH.png",
            "thumbnail_width": 400,
            "thumbnail_height": 400,
            "thumbnail_format": "auto",
            "thumbnail_url": "https://res.cloudinary.com/startup-grind/image/upload/c_fill,dpr_2,f_auto,g_face,h_400,q_auto:good,w_400/v1/gcs/platform-data-goog/events/DF23-Bevy-EventThumb-Blue_IvFpxKH.png"
          },
          "tickets": [
            {
              "id": 21792,
              "event": 60014,
              "title": "Watch us online!",
              "audience_type": "VIRTUAL",
              "description": "Get this ticket to access our livestream!",
              "access_code": null,
              "visible": true,
              "price": 0,
              "available": 10,
              "total_count": 5000,
              "sale_start_date": "2023-09-21T02:26:03+07:00",
              "sale_start_date_naive": "2023-09-21T02:26:03",
              "sale_start_date_derived_from_event_publish": true,
              "sale_end_date": "2023-11-26T17:00:00+07:00",
              "sale_end_date_naive": "2023-11-26T17:00:00",
              "sale_end_date_derived_from_event_end": true,
              "min_per_order": 0,
              "max_per_order": 10,
              "is_for_sale": false,
              "can_delete": false,
              "currency": "USD",
              "waitlist_enabled": false,
              "waitlist_count": 0,
              "attendee_count": 334,
              "used": 334,
              "discount_code": "",
              "reported_price": 0,
              "reported_fees": 0,
              "reported_original_price": 0
            },
            {
              "id": 21791,
              "event": 60014,
              "title": "In-Person Ticket!",
              "audience_type": "IN_PERSON",
              "description": "Secure your ticket to the venue in advance!",
              "access_code": null,
              "visible": true,
              "price": 0,
              "available": 0,
              "total_count": 2600,
              "sale_start_date": "2023-10-07T00:00:00+07:00",
              "sale_start_date_naive": "2023-10-07T00:00:00",
              "sale_start_date_derived_from_event_publish": false,
              "sale_end_date": "2023-11-25T23:30:00+07:00",
              "sale_end_date_naive": "2023-11-25T23:30:00",
              "sale_end_date_derived_from_event_end": false,
              "min_per_order": 0,
              "max_per_order": 10,
              "is_for_sale": false,
              "can_delete": false,
              "currency": "USD",
              "waitlist_enabled": true,
              "waitlist_count": 75,
              "attendee_count": 2567,
              "used": 2567,
              "discount_code": "",
              "reported_price": 0,
              "reported_fees": 0,
              "reported_original_price": 0
            }
          ],
          "discount_code_usable": {
            "value": false,
            "detail": "No promotion code provided."
          },
          "chapter": {
            "chapter_location": "Jakarta (ID)",
            "city": "Jakarta",
            "country": "ID",
            "country_name": "Indonesia",
            "description": "Disclaimer: GDG Jakarta is an independent group; our activities and the opinions expressed here should in no way be linked to Google, the corporation. To learn more about the GDG program, visit \u003Ca href=\"https://developers.google.com/community/gdg/\"\u003Ehttps://developers.google.com/community/gdg/\u003C/a\u003E",
            "id": 642,
            "hide_country_info": false,
            "logo": {

            },
            "state": "",
            "timezone": "Asia/Jakarta",
            "title": "GDG Jakarta",
            "relative_url": "/gdg-jakarta/",
            "url": "https://gdg.community.dev/gdg-jakarta/"
          },
          "start_date": "2023-11-26T08:45:00+07:00",
          "start_date_naive": "2023-11-26T08:45:00",
          "end_date": "2023-11-26T17:00:00+07:00",
          "end_date_naive": "2023-11-26T17:00:00",
          "start_date_iso": "2023-11-26T08:45:00+07:00",
          "end_date_iso": "2023-11-26T17:00:00+07:00",
          "internal_payment_support": true,
          "payment_client_tokens": {

          },
          "payment_methods": [],
          "payment_processor_slug": "bevypay",
          "featured_attendees": [],
          "media_partners": [4577, 4575, 5820, 4576, 5821, 4574],
          "sponsors": [],
          "partners_list": [
            {
              "id": 4577,
              "company": "Digital Hub at BSD City",
              "description": "Digital Hub is set to be the home to technology corporations and startup companies in Indonesia. Therefore, diverse commercial real estate elements are incorporated within the area with abundance of recreational amenities and educational facilities, which are Knowledge Hub and Urban Forest.\n\nThe latter is state of the art knowledge-sharing hub aimed for digital industry players to meet, exchange ideas, and collaborate.",
              "url": "https://digitalhub-bsdcity.com/",
              "logo": {
                "url": "https://res.cloudinary.com/startup-grind/image/upload/c_fill,dpr_2,f_auto,g_center,q_auto:good/v1/gcs/platform-data-goog/events/digitalhub.png",
                "path": "events/digitalhub.png",
                "thumbnail_width": 0,
                "thumbnail_height": 200,
                "thumbnail_format": "auto",
                "thumbnail_url": "https://res.cloudinary.com/startup-grind/image/upload/c_limit,dpr_2,f_auto,g_center,h_200,q_auto:good,w_200/v1/gcs/platform-data-goog/events/digitalhub.png"
              },
              "is_global": false,
              "visible": true,
              "event_sponsor_id": 11902
            },
            {
              "id": 4575,
              "company": "Sinarmas Land",
              "description": "Sinar Mas Land is the largest and most diversified property developer in Indonesia. The company is known for its rich experience of more than 50 years in the field of property development.",
              "url": "https://sinarmasland.com/",
              "logo": {
                "url": "https://res.cloudinary.com/startup-grind/image/upload/c_fill,dpr_2,f_auto,g_center,q_auto:good/v1/gcs/platform-data-goog/events/sinarmas_YSGA5dR.png",
                "path": "events/sinarmas_YSGA5dR.png",
                "thumbnail_width": 0,
                "thumbnail_height": 200,
                "thumbnail_format": "auto",
                "thumbnail_url": "https://res.cloudinary.com/startup-grind/image/upload/c_limit,dpr_2,f_auto,g_center,h_200,q_auto:good,w_200/v1/gcs/platform-data-goog/events/sinarmas_YSGA5dR.png"
              },
              "is_global": false,
              "visible": true,
              "event_sponsor_id": 11506
            },
            {
              "id": 5820,
              "company": "1000 Startup Digital",
              "description": "",
              "url": "https://1000startupdigital.id",
              "logo": {
                "url": "https://res.cloudinary.com/startup-grind/image/upload/c_fill,dpr_2,f_auto,g_center,q_auto:good/v1/gcs/platform-data-goog/events/1000slogo.png",
                "path": "events/1000slogo.png",
                "thumbnail_width": 0,
                "thumbnail_height": 200,
                "thumbnail_format": "auto",
                "thumbnail_url": "https://res.cloudinary.com/startup-grind/image/upload/c_limit,dpr_2,f_auto,g_center,h_200,q_auto:good,w_200/v1/gcs/platform-data-goog/events/1000slogo.png"
              },
              "is_global": false,
              "visible": true,
              "event_sponsor_id": 11903
            },
            {
              "id": 4576,
              "company": "tiket.com",
              "description": "",
              "url": "https://tiket.com/",
              "logo": {
                "url": "https://res.cloudinary.com/startup-grind/image/upload/c_fill,dpr_2,f_auto,g_center,q_auto:good/v1/gcs/platform-data-goog/events/tiket_JWC2K0C.png",
                "path": "events/tiket_JWC2K0C.png",
                "thumbnail_width": 0,
                "thumbnail_height": 200,
                "thumbnail_format": "auto",
                "thumbnail_url": "https://res.cloudinary.com/startup-grind/image/upload/c_limit,dpr_2,f_auto,g_center,h_200,q_auto:good,w_200/v1/gcs/platform-data-goog/events/tiket_JWC2K0C.png"
              },
              "is_global": false,
              "visible": true,
              "event_sponsor_id": 11504
            },
            {
              "id": 5821,
              "company": "Midtrans",
              "description": "",
              "url": "https://midtrans.com/",
              "logo": {
                "url": "https://res.cloudinary.com/startup-grind/image/upload/c_fill,dpr_2,f_auto,g_center,q_auto:good/v1/gcs/platform-data-goog/events/midtrans_CuWshVa.png",
                "path": "events/midtrans_CuWshVa.png",
                "thumbnail_width": 0,
                "thumbnail_height": 200,
                "thumbnail_format": "auto",
                "thumbnail_url": "https://res.cloudinary.com/startup-grind/image/upload/c_limit,dpr_2,f_auto,g_center,h_200,q_auto:good,w_200/v1/gcs/platform-data-goog/events/midtrans_CuWshVa.png"
              },
              "is_global": false,
              "visible": true,
              "event_sponsor_id": 11904
            },
            {
              "id": 4574,
              "company": "Selaksa",
              "description": "We are a passionate, creative, and easily excitable team dedicated to bringing your visions to life. We specialize in crafting digital experiences that seamlessly blend beauty and functionality, tailored specifically to meet your unique needs. By understanding your story and goals, we become your partners in success, working alongside you to transform your ideas into remarkable digital solutions.",
              "url": "https://selaksa.co/",
              "logo": {
                "url": "https://res.cloudinary.com/startup-grind/image/upload/c_fill,dpr_2,f_auto,g_center,q_auto:good/v1/gcs/platform-data-goog/events/slks_gEApiCz.png",
                "path": "events/slks_gEApiCz.png",
                "thumbnail_width": 0,
                "thumbnail_height": 200,
                "thumbnail_format": "auto",
                "thumbnail_url": "https://res.cloudinary.com/startup-grind/image/upload/c_limit,dpr_2,f_auto,g_center,h_200,q_auto:good,w_200/v1/gcs/platform-data-goog/events/slks_gEApiCz.png"
              },
              "is_global": false,
              "visible": true,
              "event_sponsor_id": 11505
            }
          ],
          "registration_required": true,
          "url": "https://gdg.community.dev/events/details/google-gdg-jakarta-presents-devfest-jakarta-2023/",
          "static_url": "https://gdg.community.dev/e/mvybv6/",
          "short_id": "mvybv6",
          "relative_url": "/events/details/google-gdg-jakarta-presents-devfest-jakarta-2023/",
          "status": "Published",
          "video_url": null,
          "slideshare_url": null,
          "event_wrapup_photos": [
            {
              "id": 36975,
              "order": 0,
              "picture": {
                "url": "https://res.cloudinary.com/startup-grind/image/upload/c_limit,dpr_2,f_auto,g_center,h_1440,q_auto:good,w_2048/v1/gcs/platform-data-goog/event_wrapup/DSC06569.JPG",
                "path": "event_wrapup/DSC06569.JPG",
                "thumbnail_width": 720,
                "thumbnail_height": 540,
                "thumbnail_format": "auto",
                "thumbnail_url": "https://res.cloudinary.com/startup-grind/image/upload/c_fill,dpr_2,f_auto,g_center,h_540,q_auto:good,w_720/v1/gcs/platform-data-goog/event_wrapup/DSC06569.JPG"
              }
            },
            {
              "id": 36964,
              "order": 1,
              "picture": {
                "url": "https://res.cloudinary.com/startup-grind/image/upload/c_limit,dpr_2,f_auto,g_center,h_1440,q_auto:good,w_2048/v1/gcs/platform-data-goog/event_wrapup/WhatsApp%2520Image%25202023-11-26%2520at%252012.56.45_4d197375.jpg",
                "path": "event_wrapup/WhatsApp Image 2023-11-26 at 12.56.45_4d197375.jpg",
                "thumbnail_width": 200,
                "thumbnail_height": 200,
                "thumbnail_format": "auto",
                "thumbnail_url": "https://res.cloudinary.com/startup-grind/image/upload/c_fill,dpr_2,f_auto,g_center,h_200,q_auto:good,w_200/v1/gcs/platform-data-goog/event_wrapup/WhatsApp%2520Image%25202023-11-26%2520at%252012.56.45_4d197375.jpg"
              }
            },
            {
              "id": 36965,
              "order": 2,
              "picture": {
                "url": "https://res.cloudinary.com/startup-grind/image/upload/c_limit,dpr_2,f_auto,g_center,h_1440,q_auto:good,w_2048/v1/gcs/platform-data-goog/event_wrapup/WhatsApp%2520Image%25202023-11-26%2520at%252012.56.44_4d497578.jpg",
                "path": "event_wrapup/WhatsApp Image 2023-11-26 at 12.56.44_4d497578.jpg",
                "thumbnail_width": 200,
                "thumbnail_height": 200,
                "thumbnail_format": "auto",
                "thumbnail_url": "https://res.cloudinary.com/startup-grind/image/upload/c_fill,dpr_2,f_auto,g_center,h_200,q_auto:good,w_200/v1/gcs/platform-data-goog/event_wrapup/WhatsApp%2520Image%25202023-11-26%2520at%252012.56.44_4d497578.jpg"
              }
            },
            {
              "id": 36967,
              "order": 3,
              "picture": {
                "url": "https://res.cloudinary.com/startup-grind/image/upload/c_limit,dpr_2,f_auto,g_center,h_1440,q_auto:good,w_2048/v1/gcs/platform-data-goog/event_wrapup/DSC07731.JPG",
                "path": "event_wrapup/DSC07731.JPG",
                "thumbnail_width": 200,
                "thumbnail_height": 200,
                "thumbnail_format": "auto",
                "thumbnail_url": "https://res.cloudinary.com/startup-grind/image/upload/c_fill,dpr_2,f_auto,g_center,h_200,q_auto:good,w_200/v1/gcs/platform-data-goog/event_wrapup/DSC07731.JPG"
              }
            },
            {
              "id": 36966,
              "order": 4,
              "picture": {
                "url": "https://res.cloudinary.com/startup-grind/image/upload/c_limit,dpr_2,f_auto,g_center,h_1440,q_auto:good,w_2048/v1/gcs/platform-data-goog/event_wrapup/DSC07970.JPG",
                "path": "event_wrapup/DSC07970.JPG",
                "thumbnail_width": 200,
                "thumbnail_height": 200,
                "thumbnail_format": "auto",
                "thumbnail_url": "https://res.cloudinary.com/startup-grind/image/upload/c_fill,dpr_2,f_auto,g_center,h_200,q_auto:good,w_200/v1/gcs/platform-data-goog/event_wrapup/DSC07970.JPG"
              }
            },
            {
              "id": 36968,
              "order": 5,
              "picture": {
                "url": "https://res.cloudinary.com/startup-grind/image/upload/c_limit,dpr_2,f_auto,g_center,h_1440,q_auto:good,w_2048/v1/gcs/platform-data-goog/event_wrapup/DSC07709.JPG",
                "path": "event_wrapup/DSC07709.JPG",
                "thumbnail_width": 200,
                "thumbnail_height": 200,
                "thumbnail_format": "auto",
                "thumbnail_url": "https://res.cloudinary.com/startup-grind/image/upload/c_fill,dpr_2,f_auto,g_center,h_200,q_auto:good,w_200/v1/gcs/platform-data-goog/event_wrapup/DSC07709.JPG"
              }
            },
            {
              "id": 36969,
              "order": 6,
              "picture": {
                "url": "https://res.cloudinary.com/startup-grind/image/upload/c_limit,dpr_2,f_auto,g_center,h_1440,q_auto:good,w_2048/v1/gcs/platform-data-goog/event_wrapup/DSC07140.JPG",
                "path": "event_wrapup/DSC07140.JPG",
                "thumbnail_width": 200,
                "thumbnail_height": 200,
                "thumbnail_format": "auto",
                "thumbnail_url": "https://res.cloudinary.com/startup-grind/image/upload/c_fill,dpr_2,f_auto,g_center,h_200,q_auto:good,w_200/v1/gcs/platform-data-goog/event_wrapup/DSC07140.JPG"
              }
            },
            {
              "id": 36970,
              "order": 7,
              "picture": {
                "url": "https://res.cloudinary.com/startup-grind/image/upload/c_limit,dpr_2,f_auto,g_center,h_1440,q_auto:good,w_2048/v1/gcs/platform-data-goog/event_wrapup/DSC07131.JPG",
                "path": "event_wrapup/DSC07131.JPG",
                "thumbnail_width": 200,
                "thumbnail_height": 200,
                "thumbnail_format": "auto",
                "thumbnail_url": "https://res.cloudinary.com/startup-grind/image/upload/c_fill,dpr_2,f_auto,g_center,h_200,q_auto:good,w_200/v1/gcs/platform-data-goog/event_wrapup/DSC07131.JPG"
              }
            },
            {
              "id": 36971,
              "order": 8,
              "picture": {
                "url": "https://res.cloudinary.com/startup-grind/image/upload/c_limit,dpr_2,f_auto,g_center,h_1440,q_auto:good,w_2048/v1/gcs/platform-data-goog/event_wrapup/DSC06796.JPG",
                "path": "event_wrapup/DSC06796.JPG",
                "thumbnail_width": 200,
                "thumbnail_height": 200,
                "thumbnail_format": "auto",
                "thumbnail_url": "https://res.cloudinary.com/startup-grind/image/upload/c_fill,dpr_2,f_auto,g_center,h_200,q_auto:good,w_200/v1/gcs/platform-data-goog/event_wrapup/DSC06796.JPG"
              }
            },
            {
              "id": 36972,
              "order": 9,
              "picture": {
                "url": "https://res.cloudinary.com/startup-grind/image/upload/c_limit,dpr_2,f_auto,g_center,h_1440,q_auto:good,w_2048/v1/gcs/platform-data-goog/event_wrapup/DSC06684.JPG",
                "path": "event_wrapup/DSC06684.JPG",
                "thumbnail_width": 200,
                "thumbnail_height": 200,
                "thumbnail_format": "auto",
                "thumbnail_url": "https://res.cloudinary.com/startup-grind/image/upload/c_fill,dpr_2,f_auto,g_center,h_200,q_auto:good,w_200/v1/gcs/platform-data-goog/event_wrapup/DSC06684.JPG"
              }
            },
            {
              "id": 36973,
              "order": 10,
              "picture": {
                "url": "https://res.cloudinary.com/startup-grind/image/upload/c_limit,dpr_2,f_auto,g_center,h_1440,q_auto:good,w_2048/v1/gcs/platform-data-goog/event_wrapup/DSC06665.JPG",
                "path": "event_wrapup/DSC06665.JPG",
                "thumbnail_width": 200,
                "thumbnail_height": 200,
                "thumbnail_format": "auto",
                "thumbnail_url": "https://res.cloudinary.com/startup-grind/image/upload/c_fill,dpr_2,f_auto,g_center,h_200,q_auto:good,w_200/v1/gcs/platform-data-goog/event_wrapup/DSC06665.JPG"
              }
            },
            {
              "id": 36974,
              "order": 11,
              "picture": {
                "url": "https://res.cloudinary.com/startup-grind/image/upload/c_limit,dpr_2,f_auto,g_center,h_1440,q_auto:good,w_2048/v1/gcs/platform-data-goog/event_wrapup/DSC06634.JPG",
                "path": "event_wrapup/DSC06634.JPG",
                "thumbnail_width": 200,
                "thumbnail_height": 200,
                "thumbnail_format": "auto",
                "thumbnail_url": "https://res.cloudinary.com/startup-grind/image/upload/c_fill,dpr_2,f_auto,g_center,h_200,q_auto:good,w_200/v1/gcs/platform-data-goog/event_wrapup/DSC06634.JPG"
              }
            }
          ],
          "meetup_url": null,
          "meetup_group": null,
          "could_update_meetup": true,
          "eventbrite_url": null,
          "completed": true,
          "show_map": true,
          "venue_name": "QBIG BSD City",
          "venue_address": "Jalan BSD Raya Utama",
          "venue_city": "Kabupaten Tangerang",
          "venue_zip_code": "15331",
          "agenda": {
            "multiday": false,
            "any_descriptions": true,
            "empty": false,
            "days": [
              {
                "title": "Convention Hall",
                "agenda": [
                  {
                    "time": "8:45 AM",
                    "activity": "Registration",
                    "description": "Please prepare your ticket barcode from the email with the subject: [TICKET CONFIRMATION] You're ready for GDG Jakarta DevFest Jakarta 2023!",
                    "audience_type": "HYBRID"
                  },
                  {
                    "time": "9:30 AM",
                    "activity": "Welcoming & Keynote",
                    "description": "Putranto Adhi Nugroho - GDG Jakarta Lead | Yanto Suryawan - Senior VP Ecosystem Relations & Promotion Digital Tech Ecosystem & Development @ Sinar Mas Land | Sonny Sudaryana - Coordinator of Digital Startup @ Ministry of Communication and Informatics Republic of Indonesia | Danang Juffry - Community Manager Google for Developers Indonesia & Brunei @ Google",
                    "audience_type": "HYBRID"
                  },
                  {
                    "time": "10:00 AM",
                    "activity": "MLOps: How to Build Model Monitoring Alerts",
                    "description": "Stephanie - Sr. Data Scientist @ JULO",
                    "audience_type": "HYBRID"
                  },
                  {
                    "time": "10:20 AM",
                    "activity": "Generative AI using Diffusion Model",
                    "description": "Williem - Independent (AI) Researcher",
                    "audience_type": "HYBRID"
                  },
                  {
                    "time": "10:40 AM",
                    "activity": "Event Based Machine Learning System Using Vertex AI",
                    "description": "Muhammad Adib Imtiyazi - Machine Learning Engineer Lead @ Tiket.com",
                    "audience_type": "HYBRID"
                  },
                  {
                    "time": "11:00 AM",
                    "activity": "ML - Q&A",
                    "description": "",
                    "audience_type": "HYBRID"
                  },
                  {
                    "time": "11:15 AM",
                    "activity": "The Journey of Unit Testing in Android Development",
                    "description": "Admoko Nugroho - Sr. Android Engineer @ DANA Indonesia",
                    "audience_type": "HYBRID"
                  },
                  {
                    "time": "11:35 AM",
                    "activity": "Building modern App Widgets with Jetpack Glance",
                    "description": "Meyta Zenis Taliti - ex-Android Engineer @ Tokopedia",
                    "audience_type": "HYBRID"
                  },
                  {
                    "time": "11:55 AM",
                    "activity": "1 App, 2 Platforms, Millions of Users: Adopting Flutter in Building GoPay",
                    "description": "Jonathan Filbert - Software Engineer @ Goto Financial (Gopay)",
                    "audience_type": "HYBRID"
                  },
                  {
                    "time": "12:15 PM",
                    "activity": "Mobile - Q&A",
                    "description": "",
                    "audience_type": "HYBRID"
                  },
                  {
                    "time": "12:30 PM",
                    "activity": "Break Time",
                    "description": "(Ishoma)",
                    "audience_type": "HYBRID"
                  },
                  {
                    "time": "1:30 PM",
                    "activity": "Firebase Crashlytics and Performance Monitoring: Ensuring App Reliability and Speed",
                    "description": "Jesslyn - Backend Engineer @ SG-EDTS & Firebase Contributors Indonesia",
                    "audience_type": "HYBRID"
                  },
                  {
                    "time": "1:50 PM",
                    "activity": "Efficiently managing your data with Cloud Firestore",
                    "description": "Cleo Credo - GDE Firebase & Engineering Lead @ Angkas | Surahutomo Aziz Pradana - GDE Firebase",
                    "audience_type": "HYBRID"
                  },
                  {
                    "time": "2:10 PM",
                    "activity": "Speeding up your app development with Firebase and Midtrans SNAP",
                    "description": "Ali Qornan Jaisyurrahman - Sr. Software Engineer @ Goto Financial (Gopay)",
                    "audience_type": "HYBRID"
                  },
                  {
                    "time": "2:30 PM",
                    "activity": "Firebase - Q&A",
                    "description": "",
                    "audience_type": "HYBRID"
                  },
                  {
                    "time": "2:45 PM",
                    "activity": "Women In Tech: The Change We Make",
                    "description": "Panelist:  \nAstrid Coenrad - Education Manager @ Generation Girl | Jessica Jaya - Co-Founder & CEO @ Apiary Academy | Jessi Febria - Co-Founder @ PetaNetra & iOS Engineer @ Traveloka",
                    "audience_type": "HYBRID"
                  },
                  {
                    "time": "3:45 PM",
                    "activity": "WTM - Q&A",
                    "description": "",
                    "audience_type": "HYBRID"
                  },
                  {
                    "time": "4:00 PM",
                    "activity": "Enhancing Web accessibility using Color blind theme in tokopedia web",
                    "description": "Dion Edo Fananie - Web Platform Engineer @ Tokopedia",
                    "audience_type": "HYBRID"
                  },
                  {
                    "time": "4:20 PM",
                    "activity": "Performance: Core Web Vitals top recommendations + INP",
                    "description": "Clinford Jordano Valencia - Software Engineer - Web",
                    "audience_type": "HYBRID"
                  },
                  {
                    "time": "4:40 PM",
                    "activity": "Web - Q&A",
                    "description": "",
                    "audience_type": "HYBRID"
                  },
                  {
                    "time": "4:55 PM",
                    "activity": "Closing & Networking",
                    "description": "Redeem your SWAGs and Google Developer Profile Badge by completing the Post-Event Survey. It will be sent to you via registered email at 16:00 WIB with the subject: [ACTION REQUIRED] How did DevFest Jakarta 2023 go?",
                    "audience_type": "HYBRID"
                  }
                ]
              }
            ]
          },
          "network_segment_max_capacity": 9,
          "currency": "USD",
          "use_external_ticketing": false,
          "use_featured_attendees": true,
          "total_capacity": null,
          "total_attendees": 2906,
          "event_type": 38,
          "event_type_slug": "conference",
          "event_type_title": "Conference",
          "event_type_logo": {

          },
          "event_type_banner": {

          },
          "event_type_rsvp_only": true,
          "event_type_allow_new_agenda": false,
          "recurring_event": null,
          "companies": [],
          "banner": {
            "url": "https://res.cloudinary.com/startup-grind/image/upload/c_fill,dpr_2,f_auto,g_center,q_auto:good/v1/gcs/platform-data-goog/event_banners/DF23-Bevy-BannerBG-Blue-v2.png",
            "path": "event_banners/DF23-Bevy-BannerBG-Blue-v2.png",
            "thumbnail_width": 1280,
            "thumbnail_height": 720,
            "thumbnail_format": "auto",
            "thumbnail_url": "https://res.cloudinary.com/startup-grind/image/upload/c_fit,dpr_2,f_auto,g_center,h_720,q_auto:good,w_1280/v1/gcs/platform-data-goog/event_banners/DF23-Bevy-BannerBG-Blue-v2.png"
          },
          "banner_crop_vertical": 0,
          "hide_agenda_on_event_page": false,
          "is_hidden": false,
          "is_test": false,
          "allow_automated_emails_when_hidden": false,
          "facebook_pixel": "",
          "linkedin_purchase_conversion_id": null,
          "visible_on_parent_chapter_only": false,
          "sharing_disabled": false,
          "is_virtual_event": true,
          "virtual_event_type": "external",
          "tags": [
            "AI",
            "Android",
            "DevFest",
            "Firebase",
            "Flutter",
            "Machine Learning",
            "Mobile",
            "Networking",
            "TensorFlow",
            "Web",
            "Women Techmakers"
          ],
          "event_timezone": "Asia/Jakarta",
          "timezone_abbreviation": "WIB",
          "_timezone": "Asia/Jakarta",
          "lobby": {
            "event": 60014,
            "external_video_url": "",
            "banner": {

            },
            "message": "[{\"children\":[{\"type\":\"line\",\"children\":[{\"text\":\"\"}]}]}]",
            "mux_upload": null,
            "video_url": "",
            "video_type": ""
          },
          "mobile_relative_event_type": "BV",
          "attendee_virtual_venue_link": "https://www.youtube.com/@GDGJakarta",
          "hide_location": false,
          "cropped_banner_url": "https://res.cloudinary.com/startup-grind/image/upload/c_scale,w_2560/c_crop,h_640,w_2560,y_0.0_mul_h_sub_0.0_mul_640/c_crop,h_640,w_2560/c_fill,dpr_2.0,f_auto,g_center,q_auto:good/v1/gcs/platform-data-goog/event_banners/DF23-Bevy-BannerBG-Blue-v2.png",
          "allows_cohosting": false,
          "cohost_registration_url": "https://gdg.community.dev/events/details/google-gdg-jakarta-presents-devfest-jakarta-2023/",
          "slug": "google-gdg-jakarta-presents-devfest-jakarta-2023",
          "facilitators": [],
          "hosts": [],
          "judges": [],
          "mentors": [],
          "moderators": [
            {
              "id": 16162,
              "first_name": "Rachel",
              "last_name": "Larasati K",
              "company": "Tokopedia",
              "title": "Product Manager",
              "bio": "",
              "picture": {
                "url": "https://res.cloudinary.com/startup-grind/image/upload/c_fill,dpr_2,f_auto,g_center,q_auto:good/v1/gcs/platform-data-goog/events/rachel%2520photo.jpeg",
                "path": "events/rachel photo.jpeg",
                "thumbnail_width": 400,
                "thumbnail_height": 400,
                "thumbnail_format": "auto",
                "thumbnail_url": "https://res.cloudinary.com/startup-grind/image/upload/c_fill,dpr_2,f_auto,g_face,h_400,q_auto:good,w_400/v1/gcs/platform-data-goog/events/rachel%2520photo.jpeg"
              },
              "personal_twitter": "",
              "company_twitter": "",
              "event_person_id": 43754
            }
          ],
          "panelists": [
            {
              "id": 15453,
              "first_name": "Astrid",
              "last_name": "Coenrad",
              "company": "Generation Girl",
              "title": "Education Manager",
              "bio": "\u003Cp\u003EI thrive on empowering others and believe in the transformative power of education. Former full time software developer, now on a mission to equip future female leaders with essential skills in STEM with Generation Girl 🚀 \u003C/p\u003E",
              "picture": {
                "url": "https://res.cloudinary.com/startup-grind/image/upload/c_fill,dpr_2,f_auto,g_center,q_auto:good/v1/gcs/platform-data-goog/events/astrid.jpg",
                "path": "events/astrid.jpg",
                "thumbnail_width": 400,
                "thumbnail_height": 400,
                "thumbnail_format": "auto",
                "thumbnail_url": "https://res.cloudinary.com/startup-grind/image/upload/c_fill,dpr_2,f_auto,g_face,h_400,q_auto:good,w_400/v1/gcs/platform-data-goog/events/astrid.jpg"
              },
              "personal_twitter": "",
              "company_twitter": "",
              "event_person_id": 42705
            },
            {
              "id": 15818,
              "first_name": "Jessi",
              "last_name": "Febria",
              "company": "iOS Engineer @ Traveloka",
              "title": "Co-Founder @ PetaNetra",
              "bio": "\u003Cp\u003EOne word to describe myself, I like to be called a “Changemaker”, someone who is fueled by the desire to make a change. \u003C/p\u003E\u003Cp\u003EAnd, it began with myself. Back in 2018, choosing computer science as my major, I, a girl unfamiliar with computers, found myself navigating a male-dominated world. Armed with a passion for math, I ventured into various ICPC competitions and enrolled in bootcamps with Metrodata and Gojek during my college years.\u003C/p\u003E\u003Cp\u003EThe desire to make a broader impact on the world ignited when I joined the Apple Developer Academy. As a team, we co-founded PetaNetra—an app designed for the visually impaired to help them navigate independently in indoor public spaces. The iOS skills I got during this experience also paved the way for my role as an iOS engineer at Traveloka.\u003C/p\u003E\u003Cp\u003ECurrently, I am someone who juggling between PetaNetra (as Co-Founder, tech lead) and Traveloka (as iOS engineer). \u003C/p\u003E\u003Cp\u003EAnother chapter from my life, is that education has always been a burning passion of mine. From being an assistant lecturer and volunteering as a teacher in rural areas during college, I continue to fuel this passion. Presently, I am an Advisor &amp; Instructor at Bangkit and a coding tutor for kids during my free time.\u003C/p\u003E",
              "picture": {
                "url": "https://res.cloudinary.com/startup-grind/image/upload/c_fill,dpr_2,f_auto,g_center,q_auto:good/v1/gcs/platform-data-goog/events/jessi.jpg",
                "path": "events/jessi.jpg",
                "thumbnail_width": 400,
                "thumbnail_height": 400,
                "thumbnail_format": "auto",
                "thumbnail_url": "https://res.cloudinary.com/startup-grind/image/upload/c_fill,dpr_2,f_auto,g_face,h_400,q_auto:good,w_400/v1/gcs/platform-data-goog/events/jessi.jpg"
              },
              "personal_twitter": "",
              "company_twitter": "traveloka",
              "event_person_id": 43092
            },
            {
              "id": 16136,
              "first_name": "Jessica Casey",
              "last_name": "Jaya",
              "company": "Co-Founder & CEO",
              "title": "Apiary Academy",
              "bio": "\u003Cp\u003EJessica is the Co-Founder and CEO of Apiary, an ecosystem for Professionals to upgrade their skills and expand their connections through events and training programs. She's passionate in organizing memorable experiences and community building. On the side, she also runs Startup Grind Jakarta, a global community of startup enthusiasts. \u003C/p\u003E",
              "picture": {
                "url": "https://res.cloudinary.com/startup-grind/image/upload/c_fill,dpr_2,f_auto,g_center,q_auto:good/v1/gcs/platform-data-goog/events/jess_s0Jl4tp.jpeg",
                "path": "events/jess_s0Jl4tp.jpeg",
                "thumbnail_width": 400,
                "thumbnail_height": 400,
                "thumbnail_format": "auto",
                "thumbnail_url": "https://res.cloudinary.com/startup-grind/image/upload/c_fill,dpr_2,f_auto,g_face,h_400,q_auto:good,w_400/v1/gcs/platform-data-goog/events/jess_s0Jl4tp.jpeg"
              },
              "personal_twitter": "",
              "company_twitter": "Apiary_ID",
              "event_person_id": 43716
            }
          ],
          "speakers": [
            {
              "id": 16317,
              "first_name": "Sonny",
              "last_name": "Sudaryana",
              "company": "Ministry of Communication and Informatics Republic of Indonesia",
              "title": "Coordinator of Digital Startup",
              "bio": "",
              "picture": {

              },
              "personal_twitter": "",
              "company_twitter": "1000startupID",
              "event_person_id": 44032
            },
            {
              "id": 16256,
              "first_name": "Yanto",
              "last_name": "Suryawan",
              "company": "Sinar Mas Land",
              "title": "Senior VP Ecosystem Relations & Promotion Digital Tech Ecosystem & Development",
              "bio": "",
              "picture": {
                "url": "https://res.cloudinary.com/startup-grind/image/upload/c_fill,dpr_2,f_auto,g_center,q_auto:good/v1/gcs/platform-data-goog/events/yanto.png",
                "path": "events/yanto.png",
                "thumbnail_width": 400,
                "thumbnail_height": 400,
                "thumbnail_format": "auto",
                "thumbnail_url": "https://res.cloudinary.com/startup-grind/image/upload/c_fill,dpr_2,f_auto,g_face,h_400,q_auto:good,w_400/v1/gcs/platform-data-goog/events/yanto.png"
              },
              "personal_twitter": "",
              "company_twitter": "sinarmas_land",
              "event_person_id": 43886
            },
            {
              "id": 6564,
              "first_name": "Danang",
              "last_name": "Juffry",
              "company": "Google",
              "title": "Community Manager Indonesia & Brunei, Developer Relations",
              "bio": "",
              "picture": {
                "url": "https://res.cloudinary.com/startup-grind/image/upload/c_fill,dpr_2,f_auto,g_center,q_auto:good/v1/gcs/platform-data-goog/events/DANANGjupri---Polos--mediumClose.png",
                "path": "events/DANANGjupri---Polos--mediumClose.png",
                "thumbnail_width": 400,
                "thumbnail_height": 400,
                "thumbnail_format": "auto",
                "thumbnail_url": "https://res.cloudinary.com/startup-grind/image/upload/c_fill,dpr_2,f_auto,g_face,h_400,q_auto:good,w_400/v1/gcs/platform-data-goog/events/DANANGjupri---Polos--mediumClose.png"
              },
              "personal_twitter": "danjuf",
              "company_twitter": "googledevsid",
              "event_person_id": 42756
            },
            {
              "id": 15663,
              "first_name": "Stephanie",
              "last_name": ".",
              "company": "JULO",
              "title": "Sr. Data Scientist",
              "bio": "\u003Cp\u003EStephanie is a Data Scientist with 3.5 years experience &amp; expertise in machine learning, financial modeling &amp; marketing optimization models. Prior to JULO, she had experience working at Gojek &amp; Unilever. She is also a teacher &amp; mentor in many DS Bootcamps &amp; Classes. \u003C/p\u003E",
              "picture": {
                "url": "https://res.cloudinary.com/startup-grind/image/upload/c_fill,dpr_2,f_auto,g_center,q_auto:good/v1/gcs/platform-data-goog/events/stephanie.jpg",
                "path": "events/stephanie.jpg",
                "thumbnail_width": 400,
                "thumbnail_height": 400,
                "thumbnail_format": "auto",
                "thumbnail_url": "https://res.cloudinary.com/startup-grind/image/upload/c_fill,dpr_2,f_auto,g_face,h_400,q_auto:good,w_400/v1/gcs/platform-data-goog/events/stephanie.jpg"
              },
              "personal_twitter": "",
              "company_twitter": "juloindonesia",
              "event_person_id": 42697
            },
            {
              "id": 15896,
              "first_name": "Williem",
              "last_name": "Pao",
              "company": "Independent (AI) Researcher",
              "title": "",
              "bio": "",
              "picture": {
                "url": "https://res.cloudinary.com/startup-grind/image/upload/c_fill,dpr_2,f_auto,g_center,q_auto:good/v1/gcs/platform-data-goog/events/williem.jpg",
                "path": "events/williem.jpg",
                "thumbnail_width": 400,
                "thumbnail_height": 400,
                "thumbnail_format": "auto",
                "thumbnail_url": "https://res.cloudinary.com/startup-grind/image/upload/c_fill,dpr_2,f_auto,g_face,h_400,q_auto:good,w_400/v1/gcs/platform-data-goog/events/williem.jpg"
              },
              "personal_twitter": "",
              "company_twitter": "",
              "event_person_id": 43254
            },
            {
              "id": 16137,
              "first_name": "Muhammad Adib",
              "last_name": "Imtiyazi",
              "company": "Tiket.com",
              "title": "Machine Learning Engineer Lead",
              "bio": "",
              "picture": {
                "url": "https://res.cloudinary.com/startup-grind/image/upload/c_fill,dpr_2,f_auto,g_center,q_auto:good/v1/gcs/platform-data-goog/events/adib.jpeg",
                "path": "events/adib.jpeg",
                "thumbnail_width": 400,
                "thumbnail_height": 400,
                "thumbnail_format": "auto",
                "thumbnail_url": "https://res.cloudinary.com/startup-grind/image/upload/c_fill,dpr_2,f_auto,g_face,h_400,q_auto:good,w_400/v1/gcs/platform-data-goog/events/adib.jpeg"
              },
              "personal_twitter": "",
              "company_twitter": "tiket",
              "event_person_id": 43721
            },
            {
              "id": 15816,
              "first_name": "Andreas Avellino Dwi Admoko",
              "last_name": "Nugroho",
              "company": "DANA Indonesia",
              "title": "Sr. Android Engineer",
              "bio": "\u003Cp\u003EAndroid engineer has been experienced more than 7 years in the industry.\u003Cbr\u003E\u003C/p\u003E",
              "picture": {
                "url": "https://res.cloudinary.com/startup-grind/image/upload/c_fill,dpr_2,f_auto,g_center,q_auto:good/v1/gcs/platform-data-goog/events/admokonugroho.png",
                "path": "events/admokonugroho.png",
                "thumbnail_width": 400,
                "thumbnail_height": 400,
                "thumbnail_format": "auto",
                "thumbnail_url": "https://res.cloudinary.com/startup-grind/image/upload/c_fill,dpr_2,f_auto,g_face,h_400,q_auto:good,w_400/v1/gcs/platform-data-goog/events/admokonugroho.png"
              },
              "personal_twitter": "",
              "company_twitter": "",
              "event_person_id": 43094
            },
            {
              "id": 8689,
              "first_name": "Meyta Zenis",
              "last_name": "Taliti",
              "company": "ex-Tokopedia",
              "title": "Android Engineer",
              "bio": "\u003Cp\u003E\u003Cbr\u003E\u003C/p\u003E",
              "picture": {
                "url": "https://res.cloudinary.com/startup-grind/image/upload/c_fill,dpr_2,f_auto,g_center,q_auto:good/v1/gcs/platform-data-goog/events/meyta.jpg",
                "path": "events/meyta.jpg",
                "thumbnail_width": 400,
                "thumbnail_height": 400,
                "thumbnail_format": "auto",
                "thumbnail_url": "https://res.cloudinary.com/startup-grind/image/upload/c_fill,dpr_2,f_auto,g_face,h_400,q_auto:good,w_400/v1/gcs/platform-data-goog/events/meyta.jpg"
              },
              "personal_twitter": "meythazennis",
              "company_twitter": "",
              "event_person_id": 42698
            },
            {
              "id": 15817,
              "first_name": "Jonathan",
              "last_name": "Filbert",
              "company": "GoTo Financial (Gopay)",
              "title": "Software Engineer",
              "bio": "\u003Cp\u003EJonathan is currently building GoPay, Indonesia's leading e-wallet platform. His impact extends to key products from Tokopedia Card, Tokopedia START Conference, and GoPayLater Cicil, impacting millions. Recognized with an IEEE award and known for his community mentorship, Jonathan is committed to democratizing technology for broader access and innovation. \u003C/p\u003E",
              "picture": {
                "url": "https://res.cloudinary.com/startup-grind/image/upload/c_fill,dpr_2,f_auto,g_center,q_auto:good/v1/gcs/platform-data-goog/events/jonathan_hqvNE3g.jpeg",
                "path": "events/jonathan_hqvNE3g.jpeg",
                "thumbnail_width": 400,
                "thumbnail_height": 400,
                "thumbnail_format": "auto",
                "thumbnail_url": "https://res.cloudinary.com/startup-grind/image/upload/c_fill,dpr_2,f_auto,g_face,h_400,q_auto:good,w_400/v1/gcs/platform-data-goog/events/jonathan_hqvNE3g.jpeg"
              },
              "personal_twitter": "jonathanfilbert",
              "company_twitter": "gopayindonesia",
              "event_person_id": 43095
            },
            {
              "id": 15452,
              "first_name": "Jesslyn",
              "last_name": ".",
              "company": "Backend Engineer @ SG-EDTS",
              "title": "",
              "bio": "\u003Cp\u003EA passionate backend engineer who loves to try new things related to the latest technology. As a Firebase contributor, I was given opportunity to build cool products and fostering a supportive developer community.\u003C/p\u003E\u003Cp\u003EAdditionally, I'm deeply interested in Artificial Intelligence, with a particular focus on Natural Language Processing (NLP) and its various applications. My enthusiasm for AI extends to exploring the ways machine learning can revolutionize industries and enhance user experiences.\u003C/p\u003E",
              "picture": {
                "url": "https://res.cloudinary.com/startup-grind/image/upload/c_fill,dpr_2,f_auto,g_center,q_auto:good/v1/gcs/platform-data-goog/events/jesslyn.jpg",
                "path": "events/jesslyn.jpg",
                "thumbnail_width": 400,
                "thumbnail_height": 400,
                "thumbnail_format": "auto",
                "thumbnail_url": "https://res.cloudinary.com/startup-grind/image/upload/c_fill,dpr_2,f_auto,g_face,h_400,q_auto:good,w_400/v1/gcs/platform-data-goog/events/jesslyn.jpg"
              },
              "personal_twitter": "",
              "company_twitter": "",
              "event_person_id": 42699
            },
            {
              "id": 13660,
              "first_name": "Cleo",
              "last_name": "Credo",
              "company": "Engineering Lead @ Angkas",
              "title": "Google Developer Expert - Firebase",
              "bio": "\u003Cp\u003ECleo is a software engineer by day and a hardware enthusiast by night. Her work focuses mainly on full-stack web engineering using Python and JavaScript. She has been working professionally in the tech industry for 7 years and counting. For the past years, she worked for projects in the smart gardening, health, education, entertainment, hospitality management, real estate, and transport industries. She worked on projects on Internet of Things (IoT) boards like Raspberry Pi, Arduino, ESP8266/32. She also is knowledgeable in Cloud Computing and Machine Learning. Currently, she is the Engineering Lead at Angkas - the top motorcycle ride-hailing and delivery app in the Philippines.\u003C/p\u003E\u003Cp\u003EShe also helps promote the tech scene in her hometown Cebu by speaking at tech conferences, workshops, and meetups as well as co-leading community-driven organizations such as Facebook Developer Circles Cebu City and PizzaPy Python Users Group and formerly on React Cebu and JavaScript Cebu.\u003C/p\u003E\u003Cp\u003EWhen away from the keyboard, she loves to travel, eat food or go up the mountains to enjoy nature.\u003C/p\u003E",
              "picture": {
                "url": "https://res.cloudinary.com/startup-grind/image/upload/c_fill,dpr_2,f_auto,g_center,q_auto:good/v1/gcs/platform-data-goog/events/Credo%252C%2520Cleo.jpg",
                "path": "events/Credo, Cleo.jpg",
                "thumbnail_width": 400,
                "thumbnail_height": 400,
                "thumbnail_format": "auto",
                "thumbnail_url": "https://res.cloudinary.com/startup-grind/image/upload/c_fill,dpr_2,f_auto,g_face,h_400,q_auto:good,w_400/v1/gcs/platform-data-goog/events/Credo%252C%2520Cleo.jpg"
              },
              "personal_twitter": "filipinacoder",
              "company_twitter": "",
              "event_person_id": 42700
            },
            {
              "id": 5117,
              "first_name": "R Surahutomo Aziz",
              "last_name": "Pradana",
              "company": "",
              "title": "Google Developer Expert - Firebase",
              "bio": "\u003Cp\u003EPradana is a person who really passionate about people and technology from the technical side and community side. In his free time, Pradana likes to research technologies and write extensively on various technical topics such as AI/ML and AR/VR to help others learn. Combining an appetite for success and a passion for communities, Pradana has won multiple international hackathons as well as spoken at various tech events.\u003C/p\u003E",
              "picture": {
                "url": "https://res.cloudinary.com/startup-grind/image/upload/c_fill,dpr_2,f_auto,g_center,q_auto:good/v1/gcs/platform-data-goog/events/aziz.jpeg",
                "path": "events/aziz.jpeg",
                "thumbnail_width": 400,
                "thumbnail_height": 400,
                "thumbnail_format": "auto",
                "thumbnail_url": "https://res.cloudinary.com/startup-grind/image/upload/c_fill,dpr_2,f_auto,g_face,h_400,q_auto:good,w_400/v1/gcs/platform-data-goog/events/aziz.jpeg"
              },
              "personal_twitter": "retzd_",
              "company_twitter": "",
              "event_person_id": 42707
            },
            {
              "id": 16138,
              "first_name": "Ali Qornan",
              "last_name": "Jaisyurrahman",
              "company": "Goto Financial (Gopay)",
              "title": "Sr. Software Engineer",
              "bio": "\u003Cp\u003EI graduated from Polytechnic around 4 years ago. After a lot of rejected job applications, fortunately, I got accepted into Gojek Engineering Bootcamp. Thus, started my journey to become a professional software engineer. I am originally a mobile app engineer but because the opportunity says so, I am more focused on the backend and DevOps. In my free time, I teach software engineering practices in the form of mentoring and coaching. I believe that a good person is a person who is useful to others. \u003C/p\u003E",
              "picture": {
                "url": "https://res.cloudinary.com/startup-grind/image/upload/c_fill,dpr_2,f_auto,g_center,q_auto:good/v1/gcs/platform-data-goog/events/ali_pFA6XsI.jpg",
                "path": "events/ali_pFA6XsI.jpg",
                "thumbnail_width": 400,
                "thumbnail_height": 400,
                "thumbnail_format": "auto",
                "thumbnail_url": "https://res.cloudinary.com/startup-grind/image/upload/c_fill,dpr_2,f_auto,g_face,h_400,q_auto:good,w_400/v1/gcs/platform-data-goog/events/ali_pFA6XsI.jpg"
              },
              "personal_twitter": "",
              "company_twitter": "gopayindonesia",
              "event_person_id": 43722
            },
            {
              "id": 15815,
              "first_name": "Dion Edo",
              "last_name": "Fananie",
              "company": "Tokopedia",
              "title": "Web Platform Engineer",
              "bio": "",
              "picture": {
                "url": "https://res.cloudinary.com/startup-grind/image/upload/c_fill,dpr_2,f_auto,g_center,q_auto:good/v1/gcs/platform-data-goog/events/dion.jpg",
                "path": "events/dion.jpg",
                "thumbnail_width": 400,
                "thumbnail_height": 400,
                "thumbnail_format": "auto",
                "thumbnail_url": "https://res.cloudinary.com/startup-grind/image/upload/c_fill,dpr_2,f_auto,g_face,h_400,q_auto:good,w_400/v1/gcs/platform-data-goog/events/dion.jpg"
              },
              "personal_twitter": "",
              "company_twitter": "tokopedia",
              "event_person_id": 43093
            },
            {
              "id": 8533,
              "first_name": "Clinford Jordano",
              "last_name": "Valencia",
              "company": "Online Travel Agent",
              "title": "Software Engineer - Web",
              "bio": "\u003Cp\u003E\u003Cbr\u003E\u003C/p\u003E",
              "picture": {
                "url": "https://res.cloudinary.com/startup-grind/image/upload/c_fill,dpr_2,f_auto,g_center,q_auto:good/v1/gcs/platform-data-goog/events/Photo%2520-%2520Clinford%2520-%2520Google%2520IO%2520Extended_wpihlui.jpeg",
                "path": "events/Photo - Clinford - Google IO Extended_wpihlui.jpeg",
                "thumbnail_width": 400,
                "thumbnail_height": 400,
                "thumbnail_format": "auto",
                "thumbnail_url": "https://res.cloudinary.com/startup-grind/image/upload/c_fill,dpr_2,f_auto,g_face,h_400,q_auto:good,w_400/v1/gcs/platform-data-goog/events/Photo%2520-%2520Clinford%2520-%2520Google%2520IO%2520Extended_wpihlui.jpeg"
              },
              "personal_twitter": "",
              "company_twitter": "",
              "event_person_id": 42701
            }
          ]
        }
        """.trimIndent()
    }
}