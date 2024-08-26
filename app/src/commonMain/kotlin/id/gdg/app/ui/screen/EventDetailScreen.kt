package id.gdg.app.ui.screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import id.gdg.app.AppViewModel
import id.gdg.app.ui.AppEvent

@Composable
fun EventDetailScreen(viewModel: AppViewModel, eventId: String) {
    val eventDetailUiState by viewModel.eventDetailUiState.collectAsState()

    LaunchedEffect(eventId) {
        if (eventId.isEmpty()) return@LaunchedEffect
        viewModel.sendEvent(AppEvent.EventDetail(eventId.toInt()))
    }

    Box {
        AnimatedVisibility(eventDetailUiState.state.isLoading) {
            CircularProgressIndicator()
        }

        when {
            eventDetailUiState.state.isSuccess -> {
                Text(text = "${eventDetailUiState.detail}")
            }
            eventDetailUiState.state.isFail -> {
                Row {
                    Text("gagal loading nih, refresh yuk")
                    Button(
                        onClick = {}
                    ) {
                        Text("Refresh")
                    }
                }
            }
        }
    }
}