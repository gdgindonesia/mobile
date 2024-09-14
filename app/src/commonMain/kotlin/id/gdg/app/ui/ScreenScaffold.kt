package id.gdg.app.ui

import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import id.gdg.app.AppViewModel
import id.gdg.app.androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import id.gdg.app.data.BottomNavBar
import id.gdg.app.data.ChapterInfoMenu
import id.gdg.app.data.HomepageMenu
import id.gdg.app.data.ProfileMenu
import id.gdg.ui.LocalWindowSizeClass
import id.gdg.ui.TwoPanelScaffold
import id.gdg.ui.TwoPanelScaffoldAnimationSpec

@Composable
fun ScreenScaffold(
    viewModel: AppViewModel,
    mainScreen: @Composable (AppViewModel, onEventDetailClicked: (String) -> Unit) -> Unit,
    detailScreen: @Composable (AppViewModel, String) -> Unit,
    navigateToDetailScreen: (String) -> Unit
) {
    var selectedEventId by rememberSaveable { mutableStateOf("") }
    var selectedBottomNavItem by rememberSaveable { mutableStateOf(HomepageMenu) }

    val windowSizeClazz = LocalWindowSizeClass.current
    var shouldPanelOpened: Boolean? by rememberSaveable { mutableStateOf(null) }
    var panelVisibility by rememberSaveable { mutableStateOf(shouldPanelOpened != null) }

    LaunchedEffect(windowSizeClazz) {
        shouldPanelOpened = shouldPanelOpened.takeIf {
            windowSizeClazz.widthSizeClass != WindowWidthSizeClass.Compact
        }

        panelVisibility = shouldPanelOpened != null
    }

    NavigationSuiteScaffold(
        navigationSuiteItems = {
            BottomNavBar.setup(
                scope = this,
                selected = { selectedBottomNavItem == it }
            ) { index ->
                selectedBottomNavItem = index
            }
        }
    ) {
        Surface {
            when (selectedBottomNavItem) {
                HomepageMenu -> TwoPanelScaffold(
                    panelVisibility = panelVisibility,
                    animationSpec = TwoPanelScaffoldAnimationSpec(
                        finishedListener = { fraction -> if (fraction == 1f) shouldPanelOpened = null }
                    ),
                    body = {
                        mainScreen(viewModel) {
                            // If the screen size is compact (or mobile device screen size), then
                            // navigate to detail page with router. Otherwise, render the [panel].
                            if (windowSizeClazz.widthSizeClass == WindowWidthSizeClass.Compact) {
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
                ChapterInfoMenu -> Text("Hi?")
                ProfileMenu -> Text("Profile")
            }
        }
    }
}