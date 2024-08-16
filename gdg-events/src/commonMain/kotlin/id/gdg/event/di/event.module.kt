package id.gdg.event.di

import id.gdg.event.data.repository.EventRepository
import id.gdg.event.data.repository.EventRepositoryImpl
import id.gdg.event.data.source.EventApi
import id.gdg.event.domain.GetHighlightPreviousEventUseCase
import id.gdg.event.domain.GetUpComingEventUseCase
import id.gdg.network.NetworkClient
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val eventModule = module {
    single<EventApi> { NetworkClient.get.create() }
    single<EventRepository> { EventRepositoryImpl(get()) }

    singleOf(::GetHighlightPreviousEventUseCase)
    singleOf(::GetUpComingEventUseCase)
}