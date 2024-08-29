@file:Suppress("FunctionName")

package id.gdg.app

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.window.ComposeUIViewController
import id.gdg.ui.DarkColorPalette
import id.gdg.ui.LightColorPalette
import id.gdg.ui.androidx.compose.material3.windowsizeclass.LocalWindowSizeClass
import id.gdg.ui.androidx.compose.material3.windowsizeclass.CommonWindowSizeClass
import id.gdg.ui.androidx.compose.material3.windowsizeclass.calculateWindowSizeClass

fun MainViewController() = ComposeUIViewController {
    BoxWithConstraints {
        val colors = if (isSystemInDarkTheme()) DarkColorPalette else LightColorPalette
        val windowSizeClass: CommonWindowSizeClass = calculateWindowSizeClass(DpSize(maxWidth, maxHeight))

        CompositionLocalProvider(LocalWindowSizeClass provides windowSizeClass) {
            MaterialTheme(colorScheme = colors) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppContent()
                }
            }
        }
    }
}