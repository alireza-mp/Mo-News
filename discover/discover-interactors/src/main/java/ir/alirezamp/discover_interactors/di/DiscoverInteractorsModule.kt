package ir.alirezamp.discover_interactors.di

import ir.alirezamp.discover_domain.reposiotry.DiscoverRepository
import ir.alirezamp.discover_domain.usecase.GetCategoriseUseCase
import ir.alirezamp.discover_domain.usecase.GetDiscoverDetailsUseCase
import ir.alirezamp.discover_interactors.repository.DiscoverRepositoryImpl
import org.koin.dsl.module

val discoverInteractorsModule = module {
    single<DiscoverRepository> {
        DiscoverRepositoryImpl(get())
    }
    single {
        GetDiscoverDetailsUseCase(get())
    }
    single {
        GetCategoriseUseCase(get())
    }
}