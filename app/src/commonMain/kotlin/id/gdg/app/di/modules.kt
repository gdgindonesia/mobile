package id.gdg.app.di

import id.gdg.chapter.di.chapterModule
import id.gdg.event.di.eventModule

val appModule = listOf(
    chapterModule,
    eventModule,
)