package ir.alirezamp.components.widget

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha

@Composable
fun InitializeView(content: @Composable () -> Unit) {
    Box(modifier = Modifier.alpha(0f)) {
        content()
    }
}
