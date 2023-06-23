package ir.alirezamp.ui_news_detail.di

import ir.alirezamp.ui_news_detail.ui.NewsDetailViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val newsDetailModule = module {
    viewModel { NewsDetailViewModel(get()) }
}