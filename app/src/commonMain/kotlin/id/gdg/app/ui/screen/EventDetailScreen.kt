package id.gdg.app.ui.screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import id.gdg.app.ui.AppEvent
import id.gdg.app.ui.state.EventDetailUiModel

@Composable
fun EventDetailScreen(
    model: EventDetailUiModel,
    onSendEvent: (AppEvent) -> Unit,
    eventId: String
) {
    LaunchedEffect(eventId) {
        if (eventId.isEmpty()) return@LaunchedEffect
        onSendEvent(AppEvent.EventDetail(eventId.toInt()))
    }

    Box {
        AnimatedVisibility(model.state.isLoading) {
            CircularProgressIndicator()
        }

        when {
            model.state.isSuccess -> {
                Text(text = "${model.detail}")
            }
            model.state.isFail -> {
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