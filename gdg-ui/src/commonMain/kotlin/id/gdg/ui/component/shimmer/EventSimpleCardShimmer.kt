package id.gdg.ui.component.shimmer

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.valentinilk.shimmer.shimmer

@Composable
fun EventSimpleCardShimmerList() {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        EventSimpleCardShimmer()
        EventSimpleCardShimmer()
        EventSimpleCardShimmer()
    }
}

@Composable
fun EventSimpleCardShimmer() {
    Row(
        modifier = Modifier
            .shimmer()
            .padding(4.dp)
    ) {
        Box(
            modifier = Modifier
                .size(48.dp, 48.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(Color.LightGray)
        )

        Column(
            modifier = Modifier
                .weight(1f)
                .padding(vertical = 10.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.LightGray)
            )
            Box(
                modifier = Modifier
                    .size(40.dp, 24.dp)
                    .background(Color.LightGray)
            )
        }
    }
}