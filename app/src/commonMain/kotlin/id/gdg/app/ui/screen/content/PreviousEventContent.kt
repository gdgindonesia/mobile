package id.gdg.app.ui.screen.content

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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