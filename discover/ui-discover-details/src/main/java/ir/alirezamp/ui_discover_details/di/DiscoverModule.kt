package ir.alirezamp.ui_discover_details.di

import ir.alirezamp.ui_discover_details.ui.DiscoverViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val discoverModule = module {
    viewModel { DiscoverViewModel(get(), get(), get(), get()) }
}