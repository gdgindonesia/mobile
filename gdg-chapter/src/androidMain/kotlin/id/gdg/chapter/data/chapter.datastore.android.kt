package id.gdg.chapter.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import id.gdg.chapter.ChapterDataStore

fun dataStore(context: Context): DataStore<Preferences> =
    ChapterDataStore.create {
        context.filesDir
            .resolve(ChapterDataStore.PREF_NAME)
            .absolutePath
    }