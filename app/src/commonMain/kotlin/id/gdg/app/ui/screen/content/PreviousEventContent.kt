package id.gdg.app.ui.screen.content

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import id.gdg.app.ui.state.common.UiState
import id.gdg.app.ui.state.partial.PreviousEventsUiModel

@Composable
fun PreviousEventContent(
    data: PreviousEventsUiModel,
    onRefreshContent: () -> Unit,
) {
    Box {
        AnimatedVisibility(data.state.isLoading) {
            CircularProgressIndicator()
        }

        when {
            data.state.isSuccess -> {
                Text(text = "${data.previousEvents}")
            }
            data.state.isFail -> {
                Row {
                    Text("gagal loading nih, refresh yuk")
                    Button(
                        onClick = { onRefreshContent() }
                    ) {
                        Text("Refresh")
                    }
                }
            }
        }
    }
}