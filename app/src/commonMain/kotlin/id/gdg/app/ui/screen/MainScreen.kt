package id.gdg.app.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import id.gdg.app.AppViewModel
import id.gdg.app.ui.AppEvent
import id.gdg.app.ui.screen.content.PreviousEventContent
import id.gdg.app.ui.screen.content.UpcomingEventContent

@Composable
fun MainScreen(
    viewModel: AppViewModel,
    onEventDetailClicked: (String) -> Unit
) {
    val chapterUiState by viewModel.chapterUiState.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.sendEvent(AppEvent.InitialContent)
    }

    Column {
        UpcomingEventContent(chapterUiState.upcomingEvent)

        PreviousEventContent(
            data = chapterUiState.previousEvents,
            onRefreshContent = {
                viewModel.sendEvent(AppEvent.FetchPreviousEvent)
            },
            onEventClicked = {
                onEventDetailClicked(it)
            }
        )
    }
}