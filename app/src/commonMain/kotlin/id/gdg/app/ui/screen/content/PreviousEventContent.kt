package id.gdg.app.ui.screen.content

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import id.gdg.app.ui.screen.uimodel.toEventContent
import id.gdg.app.ui.state.partial.PreviousEventsUiModel
import id.gdg.ui.component.EventContent
import id.gdg.ui.component.EventSimpleCard

@Composable
fun PreviousEventContent(
    data: PreviousEventsUiModel,
    onRefreshContent: () -> Unit,
    onEventClicked: (String) -> Unit,
) {
    Box {
        AnimatedVisibility(data.state.isLoading) {
            CircularProgressIndicator()
        }

        when {
            data.state.isSuccess -> {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth(),
                ) {
                    item {
                        Text(
                            text = "Previous Events",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.SemiBold
                        )
                    }

                    items(data.previousEvents.map { it.toEventContent() }) {
                        EventSimpleCard(it) { onEventClicked(it) }
                    }
                }
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