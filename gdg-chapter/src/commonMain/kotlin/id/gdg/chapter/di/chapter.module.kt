package id.gdg.chapter.di

import id.gdg.chapter.domain.GetChapterListUseCase
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val chapterModule = module {
    singleOf(::GetChapterListUseCase)
}