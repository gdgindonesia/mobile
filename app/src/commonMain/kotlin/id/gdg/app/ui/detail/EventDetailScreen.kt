package id.gdg.app.ui.detail

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EventDetailScreen(
    viewModel: EventDetailViewModel,
    eventId: String,
    fromPanel: Boolean,
    onBack: () -> Unit
) {
    val eventDetailUiState by viewModel.eventDetailUiState.collectAsState()

    LaunchedEffect(eventId) {
        if (eventId.isEmpty()) {
            onBack()
            return@LaunchedEffect
        }

        viewModel.fetch(eventId.toInt())
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {},
                navigationIcon = {
                    IconButton(
                        onClick = {
                            onBack()
                        }
                    ) {
                        Icon(
                            imageVector = if (fromPanel) {
                                Icons.Filled.Close
                            } else {
                                Icons.AutoMirrored.Filled.ArrowBack
                            },
                            contentDescription = "Close button"
                        )
                    }
                }
            )
        }
    ) {
        Box(modifier = Modifier.padding(it)) {
            AnimatedVisibility(eventDetailUiState.state.isLoading) {
                CircularProgressIndicator()
            }

            when {
                eventDetailUiState.state.isSuccess -> {
                    Text(text = "${eventDetailUiState.detail}")
                }

                eventDetailUiState.state.isFail -> {
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
}