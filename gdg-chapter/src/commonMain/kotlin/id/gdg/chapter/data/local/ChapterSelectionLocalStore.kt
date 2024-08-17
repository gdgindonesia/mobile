package id.gdg.chapter.data.local

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

interface ChapterSelectionLocalStore {

    suspend fun setChapterId(chapterId: Int)
    fun getCurrentChapterId(): Flow<Int?>
}

internal class ChapterSelectionLocalStoreImpl(
    private val store: DataStore<Preferences>
) : ChapterSelectionLocalStore {

    private val prefChapterId = intPreferencesKey("chapter_id")

    override suspend fun setChapterId(chapterId: Int) {
        store.edit { it[prefChapterId] = chapterId }
    }

    override fun getCurrentChapterId() = store.data.map { it[prefChapterId] }
}