package id.gdg.app.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import id.gdg.app.ui.AppEvent
import id.gdg.app.ui.screen.content.PreviousEventContent
import id.gdg.app.ui.screen.content.UpcomingEventContent
import id.gdg.app.ui.state.AppUiModel
import id.gdg.app.ui.state.EventChapterUiModel
import id.gdg.app.ui.state.EventDetailUiModel
import id.gdg.ui.TwoPanelScaffold
import id.gdg.ui.TwoPanelScaffoldAnimationSpec
import id.gdg.ui.androidx.compose.material3.windowsizeclass.CommonWindowSizeClass
import id.gdg.ui.androidx.compose.material3.windowsizeclass.CommonWindowWidthSizeClass
import id.gdg.ui.androidx.compose.material3.windowsizeclass.LocalWindowSizeClass
import kotlinx.coroutines.delay

@Composable
fun MainScreen(
    uiState: AppUiModel,
    detailUiState: EventDetailUiModel,
    onSendEvent: (AppEvent) -> Unit,
    navigateToDetailScreen: (String) -> Unit
) {
    var selectedChapterId by remember { mutableStateOf(uiState.chapterUiState.selectedChapterId) }
    val windowSizeClazz: CommonWindowSizeClass = LocalWindowSizeClass.current

    var shouldPanelOpened: Boolean? by rememberSaveable { mutableStateOf(null) }
    var panelVisibility by rememberSaveable { mutableStateOf(shouldPanelOpened != null) }
    var selectedEventId by rememberSaveable { mutableStateOf("") }

    LaunchedEffect(selectedChapterId) {
        onSendEvent(AppEvent.FetchPreviousEvent(selectedChapterId))
        onSendEvent(AppEvent.FetchUpcomingEvent(selectedChapterId))
    }

    LaunchedEffect(Unit) {
        delay(3_000)

        selectedChapterId = 1053
        onSendEvent(AppEvent.ChangeChapterId(selectedChapterId))
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
                chapterUiState = uiState.eventUiState,
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
                    onSendEvent(AppEvent.FetchPreviousEvent(selectedChapterId))
                }
            )
        },
        panel = {
            Surface(tonalElevation = 1.dp) {
                if (shouldPanelOpened != null) {
                    EventDetailScreen(
                        model = detailUiState,
                        eventId = selectedEventId,
                        onSendEvent = onSendEvent
                    )
                }
            }
        }
    )
}

@Composable
fun MainScreenContent(
    chapterUiState: EventChapterUiModel,
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