package id.gdg.app

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import id.gdg.app.di.appModule
import id.gdg.chapter.data.dataStore
import org.koin.core.context.startKoin
import org.koin.dsl.module

fun initKoin() {
    val dataStoreModule = module { single<DataStore<Preferences>> { dataStore() } }

    startKoin {
        modules(appModule + dataStoreModule)
    }
}