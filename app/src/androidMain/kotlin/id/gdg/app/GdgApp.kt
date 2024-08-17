package id.gdg.app

import android.app.Application
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import id.gdg.app.di.appModule
import id.gdg.chapter.data.dataStore
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.dsl.module

class GdgApp : Application() {

    override fun onCreate() {
        super.onCreate()

        val dataStoreModule = module { single<DataStore<Preferences>> { dataStore(get()) } }

        startKoin {
            androidContext(this@GdgApp)
            androidLogger()
            modules(appModule + dataStoreModule)
        }
    }
}