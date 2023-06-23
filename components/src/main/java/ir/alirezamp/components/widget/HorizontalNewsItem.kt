@file:OptIn(ExperimentalMaterial3Api::class)

package ir.alirezamp.components.widget

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import ir.alirezamp.components.R
import ir.alirezamp.components.util.IconButton
import ir.alirezamp.news_domain.model.News

@Stable
@Composable
fun HorizontalNewsItem(
    modifier: Modifier = Modifier,
    news: News,
    onItemClick: (Int) -> Unit,
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondary,
        ),
        modifier = modifier
            .fillMaxWidth()
            .height(132.dp)
            .padding(start = 16.dp, end = 16.dp, bottom = 20.dp),
        shape = MaterialTheme.shapes.large,
        onClick = { onItemClick(news.id) },
    ) {
        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .size(116.dp)
                    .padding(8.dp),
            ) {
                AsyncImage(
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(MaterialTheme.shapes.large),
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(news.imageUrl)
                        .crossfade(true)
                        .build(),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                )
                Chips(
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .padding(top = 5.dp, start = 5.dp),
                    title = news.category
                )
            }
            Spacer(modifier = Modifier.padding(end = 8.dp))
            Column(modifier = Modifier.weight(1f)) {
                Spacer(modifier = Modifier.padding(top = 5.dp))
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = news.title,
                    color = MaterialTheme.colorScheme.onSecondaryContainer,
                    style = MaterialTheme.typography.titleMedium,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    textAlign = TextAlign.Justify,
                )
                Spacer(modifier = Modifier.padding(top = 5.dp))
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = news.description,
                    color = MaterialTheme.colorScheme.onSecondary,
                    style = MaterialTheme.typography.bodyMedium,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    textAlign = TextAlign.Justify,
                )
                Spacer(modifier = Modifier.padding(top = 10.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    AsyncImage(
                        modifier = Modifier
                            .size(16.dp)
                            .clip(CircleShape),
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(news.publisherImageUrl)
                            .crossfade(true)
                            .build(),
                        contentDescription = null,
                    )
                    Spacer(modifier = Modifier.padding(end = 5.dp))
                    Text(
                        text = news.publisher,
                        color = MaterialTheme.colorScheme.onSecondaryContainer,
                        style = MaterialTheme.typography.labelSmall,
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    IconButton(
                        onClick = {
                            // Nothing
                        },
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_menu),
                            contentDescription = null,
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.padding(end = 16.dp))
        }
    }
}