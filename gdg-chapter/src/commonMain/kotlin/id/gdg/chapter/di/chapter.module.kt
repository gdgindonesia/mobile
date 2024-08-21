package id.gdg.chapter.di

import id.gdg.chapter.data.local.ChapterSelectionLocalStore
import id.gdg.chapter.data.local.ChapterSelectionLocalStoreImpl
import id.gdg.chapter.domain.GetChapterIdUseCase
import id.gdg.chapter.domain.GetChapterIdUseCaseImpl
import id.gdg.chapter.domain.GetChapterListUseCase
import id.gdg.chapter.domain.GetChapterListUseCaseImpl
import id.gdg.chapter.domain.SetChapterIdUseCase
import id.gdg.chapter.domain.SetChapterIdUseCaseImpl
import org.koin.dsl.module

val chapterModule = module {
    single<GetChapterListUseCase> { GetChapterListUseCaseImpl() }

    single<SetChapterIdUseCase> { SetChapterIdUseCaseImpl(get()) }
    single<GetChapterIdUseCase> { GetChapterIdUseCaseImpl(get()) }

    single<ChapterSelectionLocalStore> { ChapterSelectionLocalStoreImpl(get()) }
}