package ir.alirezamp.ui_discover_details.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Stable
@Composable
fun AutoSubtitle(
    modifier: Modifier = Modifier,
    visible: Boolean,
    text: String,
) {

    AnimatedVisibility(
        modifier = modifier,
        visible = visible,
        enter = fadeIn() + slideInVertically(initialOffsetY = { it / 2 }), //from bottom to top
        exit = fadeOut() + slideOutVertically(targetOffsetY = { it / 2 }), // from top to bottom
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .background(color = MaterialTheme.colorScheme.primary),
            contentAlignment = Alignment.Center,
        ) {
            AutoScrollingText(
                text = text,
                color = MaterialTheme.colorScheme.onPrimary,
                style = MaterialTheme.typography.titleLarge,
            )
        }
    }
}
