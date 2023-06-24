package ir.alirezamp.components.widget

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ir.alirezamp.components.R
import kotlinx.coroutines.delay

@Composable
fun InitializeView(content: @Composable () -> Unit) {
    var isVisibleContent by remember { mutableStateOf(false) }
    if (isVisibleContent) {
        Box(modifier = Modifier.alpha(0f)) {
            content()
        }
    } else {
        LaunchedEffect(Unit) {
            delay(3000)
            isVisibleContent = true
        }
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(id = R.drawable.splash_background),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
            )

            Image(
                modifier = Modifier
                    .align(Alignment.Center)
                    .size(148.dp, 72.dp),
                painter = painterResource(id = R.drawable.mo_news),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
            )

        }
    }
}
