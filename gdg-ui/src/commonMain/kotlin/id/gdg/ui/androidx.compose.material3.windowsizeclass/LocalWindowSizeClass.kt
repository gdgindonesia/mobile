package id.gdg.ui.androidx.compose.material3.windowsizeclass

import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.staticCompositionLocalOf

val LocalWindowSizeClass: ProvidableCompositionLocal<WindowSizeClass> =
    staticCompositionLocalOf { error("No window size class provided") }