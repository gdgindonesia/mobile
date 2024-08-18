package id.gdg.app.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import gdgindonesia.app.generated.resources.Res
import gdgindonesia.app.generated.resources.ic_logo_gdg
import kotlinx.coroutines.delay
import org.jetbrains.compose.resources.painterResource

@Composable
fun SplashScreen(
    modifier: Modifier = Modifier,
    onNavigateTo: () -> Unit,
) {
    LaunchedEffect(Unit) {
        delay(3000)
        onNavigateTo()
    }

    Box {
        Image(
            painter = painterResource(Res.drawable.ic_logo_gdg),
            contentDescription = null,
            modifier = modifier
                .width(56.dp)
                .align(Alignment.Center)
        )
    }
}