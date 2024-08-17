package id.gdg.chapter

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import okio.Path.Companion.toPath

object ChapterDataStore {

    const val PREF_NAME = "gdg_chapter.preferences_pb"

    fun create(producePath: () -> String): DataStore<Preferences> =
        PreferenceDataStoreFactory.createWithPath(
            corruptionHandler = null,
            migrations = emptyList(),
            produceFile = { producePath().toPath() },
        )
}