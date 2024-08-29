package id.gdg.app.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import id.gdg.app.AppViewModel
import id.gdg.app.ui.AppEvent
import id.gdg.app.ui.screen.content.PreviousEventContent
import id.gdg.app.ui.screen.content.UpcomingEventContent
import id.gdg.app.ui.state.ChapterUiModel
import id.gdg.ui.TwoPanelScaffold
import id.gdg.ui.TwoPanelScaffoldAnimationSpec
import id.gdg.ui.androidx.compose.material3.windowsizeclass.CommonWindowSizeClass
import id.gdg.ui.androidx.compose.material3.windowsizeclass.CommonWindowWidthSizeClass
import id.gdg.ui.androidx.compose.material3.windowsizeclass.LocalWindowSizeClass

@Composable
fun MainScreen(
    viewModel: AppViewModel,
    navigateToDetailScreen: (String) -> Unit
) {
    val chapterUiState by viewModel.chapterUiState.collectAsState()
    var selectedEventId by rememberSaveable { mutableStateOf("") }

    val windowSizeClazz: CommonWindowSizeClass = LocalWindowSizeClass.current
    var shouldPanelOpened: Boolean? by rememberSaveable { mutableStateOf(null) }
    var panelVisibility by rememberSaveable { mutableStateOf(shouldPanelOpened != null) }

    LaunchedEffect(Unit) {
        viewModel.sendEvent(AppEvent.InitialContent)
    }

    LaunchedEffect(windowSizeClazz) {
        shouldPanelOpened =
            shouldPanelOpened.takeIf { windowSizeClazz.widthSizeClass != CommonWindowWidthSizeClass.Compact }
        panelVisibility = shouldPanelOpened != null
    }

    TwoPanelScaffold(
        panelVisibility = panelVisibility,
        animationSpec = TwoPanelScaffoldAnimationSpec(
            finishedListener = { fraction -> if (fraction == 1f) shouldPanelOpened = null }
        ),
        body = {
            MainScreenContent(
                chapterUiState = chapterUiState,
                onEventDetailClicked = {
                    // If the screen size is compact (or mobile device screen size), then
                    // navigate to detail page with router. Otherwise, render the [panel].
                    if (windowSizeClazz.widthSizeClass == CommonWindowWidthSizeClass.Compact) {
                        navigateToDetailScreen(it)
                        return@MainScreenContent
                    }

                    selectedEventId = it
                    shouldPanelOpened = true
                    panelVisibility = true
                },
                onRefreshPreviousContentClicked = {
                    viewModel.sendEvent(AppEvent.FetchPreviousEvent)
                }
            )
        },
        panel = {
            Surface(tonalElevation = 1.dp) {
                if (shouldPanelOpened != null) {
                    EventDetailScreen(
                        viewModel = viewModel,
                        eventId = selectedEventId
                    )
                }
            }
        }
    )
}

@Composable
fun MainScreenContent(
    chapterUiState: ChapterUiModel,
    onEventDetailClicked: (String) -> Unit,
    onRefreshPreviousContentClicked: () -> Unit
) {
    Column {
        UpcomingEventContent(chapterUiState.upcomingEvent)

        PreviousEventContent(
            data = chapterUiState.previousEvents,
            onRefreshContent = {
                onRefreshPreviousContentClicked()
            },
            onEventClicked = {
                onEventDetailClicked(it)
            }
        )
    }
}