package id.gdg.app.ui.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import id.gdg.app.AppViewModel
import id.gdg.app.ui.state.AppEvent
import id.gdg.app.ui.state.AppUiModel

@Composable
fun MainScreen(
    state: AppUiModel,
    onFetchEventRequested: () -> Unit,
) {
    val listState = rememberLazyListState()

    LaunchedEffect(Unit) {
        onFetchEventRequested()
    }

    LazyColumn(
        state = listState,
        modifier = Modifier
            .fillMaxSize()
    ) {
        items(state.events.upcomingEvents + state.events.previousEvent) {
            Text(text = it?.title ?: "")
        }
    }
}