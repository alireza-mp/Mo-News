package ir.alirezamp.monews

import android.app.Application
import ir.alirezamp.monews.di.mainModule
import ir.alirezamp.news_datasource.ntework.di.newsNetworkModule
import ir.alirezamp.news_interactors.di.newsInteractorsModule
import ir.alirezamp.news_list.di.newsListModule
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
            )
        }
    }

}