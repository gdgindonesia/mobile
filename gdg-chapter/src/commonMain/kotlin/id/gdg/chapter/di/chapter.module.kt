package id.gdg.chapter.di

import id.gdg.chapter.data.local.ChapterSelectionLocalStore
import id.gdg.chapter.data.local.ChapterSelectionLocalStoreImpl
import id.gdg.chapter.domain.GetChapterIdUseCase
import id.gdg.chapter.domain.GetChapterListUseCase
import id.gdg.chapter.domain.SetChapterIdUseCase
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val chapterModule = module {
    singleOf(::GetChapterListUseCase)

    singleOf(::GetChapterIdUseCase)
    singleOf(::SetChapterIdUseCase)

    single<ChapterSelectionLocalStore> { ChapterSelectionLocalStoreImpl(get()) }
}