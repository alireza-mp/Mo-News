package ir.alirezamp.components.widget

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import ir.alirezamp.components.util.NoRippleInteractionSource

@Composable
fun ErrorView(
    message: String,
    onRetry: () -> Unit,
) {
    Surface(color = MaterialTheme.colorScheme.surface) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center,
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "خطایی پیش آمده!",
                    color = MaterialTheme.colorScheme.onSurface,
                    style = MaterialTheme.typography.titleLarge,
                    textAlign = TextAlign.Center,
                )
                Spacer(modifier = Modifier.padding(top = 10.dp))
                TextButton(
                    onClick = onRetry,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Transparent,
                    ),
                    interactionSource = NoRippleInteractionSource(),
                ) {
                    Text(
                        text = "تلاش مجدد",
                        color = MaterialTheme.colorScheme.inverseOnSurface,
                        style = MaterialTheme.typography.titleSmall,
                        textAlign = TextAlign.Center,
                    )
                }
            }
        }
    }

}