package ir.alirezamp.components.widget

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ehsanmsz.mszprogressindicator.progressindicator.BallPulseProgressIndicator

@Composable
fun LoadingView() {
    Surface(contentColor = MaterialTheme.colorScheme.surface) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            BallPulseProgressIndicator(
                color = MaterialTheme.colorScheme.primary,
                ballCount = 4,
                spacing = 6.dp
            )
        }
    }
}