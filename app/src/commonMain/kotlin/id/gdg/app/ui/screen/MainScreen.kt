package id.gdg.app.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
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
    var hasDetailOpened: Boolean? by rememberSaveable { mutableStateOf(null) }
    var showSidePanel by rememberSaveable {
        mutableStateOf(hasDetailOpened != null).also {
            println("showsidepanel: ${it.value}")
        }
    }

    LaunchedEffect(Unit) {
        viewModel.sendEvent(AppEvent.InitialContent)
    }

    LaunchedEffect(windowSizeClazz) {
        hasDetailOpened =
            hasDetailOpened.takeIf { windowSizeClazz.widthSizeClass != CommonWindowWidthSizeClass.Compact }
        println("hasdetail: $hasDetailOpened")
        println("apaini: ${windowSizeClazz.widthSizeClass != CommonWindowWidthSizeClass.Compact}")
        showSidePanel = hasDetailOpened != null
    }

    TwoPanelScaffold(
        panelVisibility = showSidePanel,
        animationSpec = TwoPanelScaffoldAnimationSpec(
            finishedListener = { fraction -> if (fraction == 1f) hasDetailOpened = null }
        ),
        body = {
            MainScreenView(
                chapterUiState = chapterUiState,
                onEventDetailClicked = {
                    // If the screen size is compact (or mobile device screen size), then
                    // navigate to detail page with router. Otherwise, render the [panel].
                    if (windowSizeClazz.widthSizeClass == CommonWindowWidthSizeClass.Compact) {
                        navigateToDetailScreen(it)
                        return@MainScreenView
                    }

                    selectedEventId = it
                    hasDetailOpened = true
                    showSidePanel = true
                },
                onRefreshPreviousContentClicked = {
                    viewModel.sendEvent(AppEvent.FetchPreviousEvent)
                }
            )
        },
        panel = {
            Surface(tonalElevation = 1.dp) {
                if (hasDetailOpened != null) {
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
fun MainScreenView(
    chapterUiState: ChapterUiModel,
    onEventDetailClicked: (String) -> Unit,
    onRefreshPreviousContentClicked: () -> Unit
) {
    Column {
        UpcomingEventContent(chapterUiState.upcomingEvent)

        Button(
            onClick = {
                onEventDetailClicked("60014")
            }
        ) {
            Text("Show Detail")
        }

        PreviousEventContent(
            data = chapterUiState.previousEvents,
            onRefreshContent = {
                onRefreshPreviousContentClicked()
            }
        )
    }
}