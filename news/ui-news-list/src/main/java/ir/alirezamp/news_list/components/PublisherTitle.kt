package ir.alirezamp.news_list.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest

@Composable
fun PublisherTitle(
    modifier: Modifier = Modifier,
    padding: PaddingValues = PaddingValues(),
    title: String,
    imageUrl: String,
    onClick: () -> Unit,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(padding),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        AsyncImage(
            modifier = Modifier
                .size(28.dp)
                .clip(CircleShape),
            model = ImageRequest.Builder(LocalContext.current)
                .data(imageUrl)
                .crossfade(true)
                .build(),
            contentDescription = null,
        )
        Spacer(modifier = Modifier.padding(end = 10.dp))
        Text(
            title,
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.onSurface,
        )
        Spacer(modifier = Modifier.weight(1f))
        TextButton(onClick = onClick) {
            Text(
                text = "مشاهده بیشتر",
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.inverseOnSurface,
            )
        }
    }
}