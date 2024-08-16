package id.gdg.event.data.source

import de.jensklingenberg.ktorfit.http.GET
import de.jensklingenberg.ktorfit.http.Path
import id.gdg.event.data.entity.Events

interface EventApi {

    @GET("https://gdg.community.dev/api/event_slim/for_chapter/{chapter_id}?page_size=1&status=Live")
    suspend fun upcomingEvent(@Path("chapter_id") chapterId: Int): Events

    @GET("https://gdg.community.dev/api/event_slim/for_chapter/{chapter_id}?page_size=3&status=Completed")
    suspend fun pastEvent(@Path("chapter_id") chapterId: Int): Events
}