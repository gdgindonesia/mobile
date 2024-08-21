package id.gdg.app.ui.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import id.gdg.app.ui.state.ChapterUiModel

@Composable
fun MainScreen(
    state: ChapterUiModel,
    onChapterChanged: (Int) -> Unit
) {
    val listState = rememberLazyListState()

    LazyColumn(
        state = listState,
        modifier = Modifier
            .fillMaxSize()
    ) {
        items(state.previousEvents) {
            Text(text = it.title)
        }
        item {
            Button(
                onClick = {
                    onChapterChanged(681)
                }
            ) {
                Text("Random")
            }
        }
    }
}