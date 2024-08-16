package id.gdg.app

import android.app.Application
import id.gdg.app.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class GdgApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@GdgApp)
            androidLogger()
            modules(appModule)
        }
    }
}