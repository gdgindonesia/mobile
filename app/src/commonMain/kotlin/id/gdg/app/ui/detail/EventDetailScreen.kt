package id.gdg.app.ui.detail

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

@Composable
fun EventDetailScreen(
    viewModel: EventDetailViewModel,
    eventId: String,
    onBack: () -> Unit
) {
    val eventDetailUiState by viewModel.eventDetailUiState.collectAsState()

    LaunchedEffect(eventId) {
        if (eventId.isEmpty()) {
            onBack()
            return@LaunchedEffect
        }

        viewModel.fetch(eventId.toInt())
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