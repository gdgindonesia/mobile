package id.gdg.app.ui.main.content

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import id.gdg.app.ui.main.state.PreviousEventsUiModel
import id.gdg.ui.component.EventSimpleCard
import id.gdg.ui.component.HeadlineSection
import id.gdg.ui.component.shimmer.EventSimpleCardShimmerList

@Composable
fun PreviousEventContent(
    data: PreviousEventsUiModel,
    onRefreshContent: () -> Unit,
    onEventClicked: (String) -> Unit,
) {
    Box(
        modifier = Modifier
            .padding(12.dp)
    ) {
        AnimatedVisibility(data.state.isLoading) {
            EventSimpleCardShimmerList()
        }

        when {
            data.state.isSuccess -> {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth(),
                ) {
                    item { HeadlineSection("Previous Events") }

                    items(data.toEventContent()) {
                        EventSimpleCard(it) { eventId ->
                            onEventClicked(eventId)
                        }
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