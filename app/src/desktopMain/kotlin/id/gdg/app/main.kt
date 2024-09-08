@file:OptIn(ExperimentalMaterial3WindowSizeClassApi::class)

package id.gdg.app

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.window.WindowDraggableArea
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowScope
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import id.gdg.app.di.appModule
import id.gdg.chapter.data.dataStore
import id.gdg.ui.DarkColorPalette
import id.gdg.ui.LightColorPalette
import id.gdg.ui.LocalWindowSizeClass
import org.koin.core.context.startKoin
import org.koin.dsl.module

fun main() = application {
    val windowState: WindowState = rememberWindowState()

    initKoin()

    Window(
        onCloseRequest = ::exitApplication,
        title = "GDG Indonesia",
    ) {
        AppWindowTitleBar()

        val colors = if (isSystemInDarkTheme()) DarkColorPalette else LightColorPalette

        CompositionLocalProvider(
            LocalWindowSizeClass provides calculateWindowSizeClass()
        ) {
            MaterialTheme(colorScheme = colors) {
                AppContent()
            }
        }
    }
}

fun initKoin() {
    val dataStoreModule = module { single<DataStore<Preferences>> { dataStore() } }

    startKoin {
        modules(appModule + dataStoreModule)
    }
}

@Composable
private fun WindowScope.AppWindowTitleBar() = WindowDraggableArea {
    Box(Modifier.fillMaxWidth().height(48.dp).background(Color.DarkGray))
}