package id.gdg.ui.androidx.compose.material3.windowsizeclass

import android.app.Activity
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowHeightSizeClass
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Composable
fun calculateWindowSizeClass(activity: Activity): CommonWindowSizeClass =
    calculateWindowSizeClass(activity).map()

fun WindowSizeClass.map(): CommonWindowSizeClass {
    return CommonWindowSizeClass(
        widthSizeClass = widthSizeClass.trasnform(),
        heightSizeClass = heightSizeClass.trasnform()
    )
}

fun WindowWidthSizeClass.trasnform(): CommonWindowWidthSizeClass {
    return when {
        this == WindowWidthSizeClass.Compact -> CommonWindowWidthSizeClass.Compact
        this == WindowWidthSizeClass.Medium -> CommonWindowWidthSizeClass.Medium
        else -> CommonWindowWidthSizeClass.Expanded
    }
}

fun WindowHeightSizeClass.trasnform(): CommonWindowHeightSizeClass {
    return when {
        this == WindowHeightSizeClass.Compact -> CommonWindowHeightSizeClass.Compact
        this == WindowHeightSizeClass.Medium -> CommonWindowHeightSizeClass.Medium
        else -> CommonWindowHeightSizeClass.Expanded
    }
}