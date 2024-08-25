package id.gdg.app

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import id.gdg.app.di.ViewModelFactory
import id.gdg.app.ui.AppContent
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App(viewModel: AppViewModel = ViewModelFactory.create()) {
    MaterialTheme {
        AppContent()
    }
}