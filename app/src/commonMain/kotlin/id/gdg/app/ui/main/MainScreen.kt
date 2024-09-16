package id.gdg.app.ui.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import id.gdg.app.ui.main.content.PreviousEventContent
import id.gdg.app.ui.main.content.UpcomingEventContent

@Composable
fun MainScreen(
    viewModel: MainViewModel,
    onEventDetailClicked: (String) -> Unit
) {
    val chapterUiState by viewModel.chapterUiState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        UpcomingEventContent(
            data = chapterUiState.upcomingEvent,
            onRefreshContent = {
                viewModel.sendEvent(MainEvent.FetchUpcomingEvent)
            },
            onEventClicked = {
                onEventDetailClicked(it)
            }
        )

        PreviousEventContent(
            data = chapterUiState.previousEvents,
            onRefreshContent = {
                viewModel.sendEvent(MainEvent.FetchPreviousEvent)
            },
            onEventClicked = {
                onEventDetailClicked(it)
            }
        )
    }
}