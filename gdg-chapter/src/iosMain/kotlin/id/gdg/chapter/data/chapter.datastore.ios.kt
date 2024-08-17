package id.gdg.chapter.data

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import id.gdg.chapter.ChapterDataStore
import kotlinx.cinterop.ExperimentalForeignApi
import platform.Foundation.NSDocumentDirectory
import platform.Foundation.NSFileManager
import platform.Foundation.NSURL
import platform.Foundation.NSUserDomainMask

@OptIn(ExperimentalForeignApi::class)
fun dataStore(): DataStore<Preferences> = ChapterDataStore.create {
    val documentDirectory: NSURL? = NSFileManager.defaultManager.URLForDirectory(
        directory = NSDocumentDirectory,
        inDomain = NSUserDomainMask,
        appropriateForURL = null,
        create = false,
        error = null,
    )

    requireNotNull(documentDirectory).path + "/${ChapterDataStore.PREF_NAME}"
}