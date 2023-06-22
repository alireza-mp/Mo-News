package ir.alirezamp.publisher_datasource.network.di

import ir.alirezamp.publisher_datasource.network.service.PublisherDatasource
import ir.alirezamp.publisher_datasource.network.service.PublisherDatasourceImpl
import ir.alirezamp.publisher_domain.usecase.GetPublishersUseCase
import org.koin.dsl.module

val publisherNetworkModule = module {
    single<PublisherDatasource> {
        PublisherDatasourceImpl(get())
    }
    single {
        GetPublishersUseCase(get())
    }
}