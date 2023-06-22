package ir.alirezamp.discover_datasource.network.di

import ir.alirezamp.discover_datasource.network.service.DiscoverDatasource
import ir.alirezamp.discover_datasource.network.service.DiscoverDatasourceImpl
import org.koin.dsl.module


val discoverNetworkModule = module {
    single<DiscoverDatasource> {
        DiscoverDatasourceImpl(get())
    }
}

