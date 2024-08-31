package id.gdg.app.di

import id.gdg.app.common.MainUpdateScope
import id.gdg.app.common.UpdateScope
import id.gdg.app.update.ChapterEventUpdate
import id.gdg.app.update.ChapterEventUpdateImpl
import id.gdg.app.update.ChapterUpdate
import id.gdg.app.update.ChapterUpdateImpl
import id.gdg.app.update.EventDetailUpdate
import id.gdg.app.update.EventDetailUpdateImpl
import id.gdg.chapter.di.chapterModule
import id.gdg.event.di.eventModule
import org.koin.dsl.module

val updateModule = module {
    single<UpdateScope> { MainUpdateScope() }
    single<ChapterUpdate> { ChapterUpdateImpl(get(), get(), get(), get()) }
    single<EventDetailUpdate> { EventDetailUpdateImpl(get(), get()) }
    single<ChapterEventUpdate> { ChapterEventUpdateImpl(get(), get(), get()) }
}

val appModule = listOf(
    updateModule,
    chapterModule,
    eventModule,
)