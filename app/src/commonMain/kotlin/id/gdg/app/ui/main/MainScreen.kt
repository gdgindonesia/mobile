package id.gdg.app.ui.main

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import id.gdg.app.ui.main.content.PreviousEventContent
import id.gdg.app.ui.main.content.UpcomingEventContent

@Composable
fun MainScreen(
    viewModel: MainViewModel,
    onEventDetailClicked: (String) -> Unit
) {
    val chapterUiState by viewModel.chapterUiState.collectAsState()

    Column {
        UpcomingEventContent(chapterUiState.upcomingEvent)

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