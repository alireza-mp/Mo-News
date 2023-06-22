package ir.alirezamp.publisher_interactors.di

import ir.alirezamp.publisher_domain.reposiotry.PublisherRepository
import ir.alirezamp.publisher_interactors.repository.PublisherRepositoryImpl
import org.koin.dsl.module

val publisherInteractorsModule = module {
    single<PublisherRepository> {
        PublisherRepositoryImpl(get())
    }
}