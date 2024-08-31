package id.gdg.app.ui

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import id.gdg.app.AppViewModel
import id.gdg.ui.TwoPanelScaffold
import id.gdg.ui.TwoPanelScaffoldAnimationSpec
import id.gdg.ui.androidx.compose.material3.windowsizeclass.CommonWindowSizeClass
import id.gdg.ui.androidx.compose.material3.windowsizeclass.CommonWindowWidthSizeClass
import id.gdg.ui.androidx.compose.material3.windowsizeclass.LocalWindowSizeClass

@Composable
fun ScreenScaffold(
    viewModel: AppViewModel,
    mainScreen: @Composable (AppViewModel, onEventDetailClicked: (String) -> Unit) -> Unit,
    detailScreen: @Composable (AppViewModel, String) -> Unit,
    navigateToDetailScreen: (String) -> Unit
) {
    var selectedEventId by rememberSaveable { mutableStateOf("") }

    val windowSizeClazz: CommonWindowSizeClass = LocalWindowSizeClass.current
    var shouldPanelOpened: Boolean? by rememberSaveable { mutableStateOf(null) }
    var panelVisibility by rememberSaveable { mutableStateOf(shouldPanelOpened != null) }

    LaunchedEffect(windowSizeClazz) {
        shouldPanelOpened = shouldPanelOpened.takeIf {
            windowSizeClazz.widthSizeClass != CommonWindowWidthSizeClass.Compact
        }

        panelVisibility = shouldPanelOpened != null
    }

    TwoPanelScaffold(
        panelVisibility = panelVisibility,
        animationSpec = TwoPanelScaffoldAnimationSpec(
            finishedListener = { fraction -> if (fraction == 1f) shouldPanelOpened = null }
        ),
        body = {
            mainScreen(viewModel) {
                // If the screen size is compact (or mobile device screen size), then
                // navigate to detail page with router. Otherwise, render the [panel].
                if (windowSizeClazz.widthSizeClass == CommonWindowWidthSizeClass.Compact) {
                    navigateToDetailScreen(it)
                    return@mainScreen
                }

                selectedEventId = it
                shouldPanelOpened = true
                panelVisibility = true
            }
        },
        panel = {
            Surface(tonalElevation = 1.dp) {
                if (shouldPanelOpened != null) {
                    detailScreen(viewModel, selectedEventId)
                }
            }
        }
    )
}