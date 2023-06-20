package ir.alirezamp.news_list.di

import ir.alirezamp.news_list.ui.suggested_news.SuggestedNewsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val newsListModule = module {
    viewModel { SuggestedNewsViewModel(get(), get()) }
}