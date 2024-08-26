package id.gdg.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import id.gdg.app.ui.AppContent
import id.gdg.ui.DarkColorPalette
import id.gdg.ui.LightColorPalette
import id.gdg.ui.androidx.compose.material3.windowsizeclass.CommonWindowSizeClass
import id.gdg.ui.androidx.compose.material3.windowsizeclass.LocalWindowSizeClass
import id.gdg.ui.androidx.compose.material3.windowsizeclass.calculateWindowSizeClass

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val colors = if (isSystemInDarkTheme()) DarkColorPalette else LightColorPalette
            val windowSizeClass: CommonWindowSizeClass = calculateWindowSizeClass(this)

            CompositionLocalProvider(LocalWindowSizeClass provides windowSizeClass) {
                MaterialTheme(
                    colorScheme = colors
                ) {
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
}
