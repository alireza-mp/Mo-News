package ir.alirezamp.monews

import android.app.Application
import ir.alirezamp.news_list.di.newsListModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@BaseApplication)
            modules(
                newsListModule,
            )
        }
    }

}