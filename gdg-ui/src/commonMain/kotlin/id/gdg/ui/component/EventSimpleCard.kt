package id.gdg.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.seiko.imageloader.model.ImageAction
import com.seiko.imageloader.rememberImageSuccessPainter
import com.seiko.imageloader.ui.AutoSizeBox

@Composable
fun EventSimpleCard(
    id: String,
    bannerUrl: String,
    eventName: String,
    date: String,
    type: String,
    navigateToEvent: (String) -> Unit
) {
    Row(
        modifier = Modifier
            .clickable(onClick = { navigateToEvent(id) })
            .padding(4.dp)
    ) {
        EventBannerImage(
            url = bannerUrl,
            modifier = Modifier
                .padding(16.dp)
        )
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(vertical = 10.dp)
        ) {
            EventTitle(eventName)
            DateAndAudienceType(date, type)
        }
    }
}

@Composable
fun EventTitle(title: String) {
    Text(
        text = title,
        style = MaterialTheme.typography.titleMedium,
        maxLines = 3,
        overflow = TextOverflow.Ellipsis,
    )
}

@Composable
fun DateAndAudienceType(
    date: String,
    type: String,
    modifier: Modifier = Modifier
) {
    Row(modifier) {
        Text(
            text = "$date - $type",
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Composable
private fun EventBannerImage(url: String?, modifier: Modifier = Modifier) {
    if (url.isNullOrEmpty()) return

    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center,
    ) {
        AutoSizeBox(url = url) { action ->
            when (action) {
                is ImageAction.Success -> {
                    Image(
                        modifier = Modifier
                            .size(48.dp, 48.dp)
                            .clip(RoundedCornerShape(8.dp)),
                        contentScale = ContentScale.Crop,
                        painter = rememberImageSuccessPainter(action),
                        contentDescription = null,
                    )
                }
                is ImageAction.Loading -> {
                    CircularProgressIndicator(
                        modifier = Modifier
                            .align(Alignment.Center)
                            .size(48.dp),
                        color = MaterialTheme.colorScheme.tertiary,
                    )
                }
                is ImageAction.Failure -> {} // TODO: Placeholder
            }
        }
    }
}
