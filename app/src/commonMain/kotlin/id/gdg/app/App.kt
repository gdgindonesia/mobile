package id.gdg.app

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import gdgindonesia.app.generated.resources.Res
import gdgindonesia.app.generated.resources.compose_multiplatform
import id.gdg.app.di.ViewModelFactory
import id.gdg.chapter.domain.GetChapterListUseCase
import kotlinx.coroutines.launch

@Composable
@Preview
fun App(viewModel: AppViewModel = ViewModelFactory.create()) {
    MaterialTheme {
        var showContent by remember { mutableStateOf(false) }
        val state by viewModel.previousEvents.collectAsState()

        LaunchedEffect(Unit) {
            viewModel.getUpcomingEvent()
        }

        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Button(onClick = { showContent = !showContent }) {
                Text("Click me!")
            }
            AnimatedVisibility(showContent) {
                Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(painterResource(Res.drawable.compose_multiplatform), null)
                    Text("Compose: $state")
                }
            }
        }
    }
}