@file:OptIn(ExperimentalMaterial3Api::class)

package ir.alirezamp.components.widget

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import ir.alirezamp.publisher_domain.model.Publisher

@Stable
@Composable
fun PublisherItem(
    modifier: Modifier = Modifier,
    publisher: Publisher,
    onItemClick: (Int, Boolean) -> Unit,
) {
    Card(
        modifier = modifier.size(133.dp, 160.dp),
        onClick = { onItemClick(publisher.id, !publisher.flowing.value) },
        shape = MaterialTheme.shapes.medium,
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondary),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp, horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            AsyncImage(
                modifier = Modifier
                    .size(56.dp)
                    .clip(CircleShape),
                model = ImageRequest.Builder(LocalContext.current)
                    .data(publisher.imageUrl)
                    .crossfade(true)
                    .build(),
                contentDescription = null,
                contentScale = ContentScale.Crop,
            )
            Spacer(modifier = Modifier.padding(top = 16.dp))
            Text(
                text = publisher.title,
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                style = MaterialTheme.typography.titleSmall,
            )
            Spacer(modifier = Modifier.padding(top = 10.dp))
            Chips(
                title = if (publisher.flowing.value) "دنبال میکنید" else "دنبال کردن",
                enabled = true,
                onClick = { onItemClick(publisher.id, !publisher.flowing.value) },
            )
        }

    }

}