package id.gdg.event.data.source

import de.jensklingenberg.ktorfit.http.GET
import de.jensklingenberg.ktorfit.http.Path
import de.jensklingenberg.ktorfit.http.Query
import id.gdg.event.data.entity.Events
import id.gdg.network.Url

interface EventApi {

    @GET("${Url.PATH_EVENT}/{chapter_id}")
    suspend fun fetchEvent(
        @Path("chapter_id") chapterId: Int,
        @Query("page_size") pageSize: Int,
        @Query("status") status: String,

        /**
         * This is a tricky way that Bevy provides to us :).
         * Forcibly as Desc as we only need to show a latest event one.
         *
         * -start_date = descending
         * start_date = ascending
         */
        @Query("order") order: String = "-start_date",
    ): Events
}