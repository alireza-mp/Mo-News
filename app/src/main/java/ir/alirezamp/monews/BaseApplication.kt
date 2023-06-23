package ir.alirezamp.monews

import android.app.Application
import ir.alirezamp.discover_datasource.network.di.discoverNetworkModule
import ir.alirezamp.discover_interactors.di.discoverInteractorsModule
import ir.alirezamp.monews.di.mainModule
import ir.alirezamp.news_datasource.ntework.di.newsNetworkModule
import ir.alirezamp.news_interactors.di.newsInteractorsModule
import ir.alirezamp.news_list.di.newsListModule
import ir.alirezamp.publisher_datasource.network.di.publisherNetworkModule
import ir.alirezamp.publisher_interactors.di.publisherInteractorsModule
import ir.alirezamp.ui_discover_details.di.discoverModule
import ir.alirezamp.ui_news_detail.di.newsDetailModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@BaseApplication)
            modules(
                mainModule,
                newsListModule,
                newsNetworkModule,
                newsInteractorsModule,
                discoverModule,
                discoverNetworkModule,
                discoverInteractorsModule,
                publisherNetworkModule,
                publisherInteractorsModule,
                newsDetailModule,
            )
        }
    }

}