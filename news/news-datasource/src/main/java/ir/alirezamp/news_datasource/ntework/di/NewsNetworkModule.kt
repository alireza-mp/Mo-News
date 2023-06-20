package ir.alirezamp.news_datasource.ntework.di

import ir.alirezamp.news_datasource.ntework.service.NewsService
import ir.alirezamp.news_datasource.ntework.service.NewsServiceImpl
import org.koin.dsl.module

val newsNetworkModule = module {
    single<NewsService> {
        NewsServiceImpl(get())
    }
}