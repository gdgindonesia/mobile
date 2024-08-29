package id.gdg.chapter.data

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import id.gdg.chapter.ChapterDataStore

fun dataStore(): DataStore<Preferences> = ChapterDataStore.create {
    ChapterDataStore.PREF_NAME
}