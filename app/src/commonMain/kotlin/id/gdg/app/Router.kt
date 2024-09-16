package id.gdg.app

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

interface Router

inline fun <reified R : Router> NavGraphBuilder.safeComposable(
    noinline content: @Composable AnimatedContentScope.(NavBackStackEntry) -> Unit
) = composable<R>(content = content)