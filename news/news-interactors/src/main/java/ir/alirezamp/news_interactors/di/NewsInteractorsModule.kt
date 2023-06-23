package ir.alirezamp.news_interactors.di

import ir.alirezamp.news_domain.reposiotry.NewsRepository
import ir.alirezamp.news_domain.usecase.GetEditorSuggestionNewsUseCase
import ir.alirezamp.news_domain.usecase.GetFavoriteNewsUseCase
import ir.alirezamp.news_domain.usecase.GetHotNewsUseCase
import ir.alirezamp.news_domain.usecase.GetNewsDetailUseCase
import ir.alirezamp.news_domain.usecase.GetPublisherNewsUseCase
import ir.alirezamp.news_interactors.repository.NewsRepositoryImpl
import org.koin.dsl.module

val newsInteractorsModule = module {
    single<NewsRepository> {
        NewsRepositoryImpl(get())
    }
    single {
        GetHotNewsUseCase(get())
    }
    single {
        GetFavoriteNewsUseCase(get())
    }
    single {
        GetEditorSuggestionNewsUseCase(get())
    }
    single {
        GetPublisherNewsUseCase(get())
    }
    single {
        GetNewsDetailUseCase(get())
    }
}