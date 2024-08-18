package id.gdg.event.di

import id.gdg.event.data.repository.EventDetailRepository
import id.gdg.event.data.repository.EventDetailRepositoryImpl
import id.gdg.event.data.repository.EventRepository
import id.gdg.event.data.repository.EventRepositoryImpl
import id.gdg.event.data.source.EventApi
import id.gdg.event.domain.GetEventsUseCase
import id.gdg.event.domain.GetEventDetailUseCase
import id.gdg.event.domain.GetPreviousEventUseCase
import id.gdg.event.domain.GetUpComingEventUseCase
import id.gdg.network.NetworkClient
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val eventModule = module {
    single<EventApi> { NetworkClient.get.create() }

    // Repositories
    single<EventRepository> { EventRepositoryImpl(get()) }
    single<EventDetailRepository> { EventDetailRepositoryImpl(get()) }

    // Domains
    singleOf(::GetPreviousEventUseCase)
    singleOf(::GetUpComingEventUseCase)
    singleOf(::GetEventsUseCase)

    singleOf(::GetEventDetailUseCase)
}