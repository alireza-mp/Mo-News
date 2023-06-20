@file:OptIn(ExperimentalMaterial3Api::class)

package ir.alirezamp.components.widget


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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


@Composable
fun VerticalNewsItem(
    modifier: Modifier = Modifier,
    news: News,
    onNewsClick: (Int) -> Unit,
) {
    Card(
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondary),
        modifier = modifier
            .width(279.dp)
            .height(294.dp)
            .padding(end = 16.dp, start = 1.dp),
        shape = MaterialTheme.shapes.large,
        onClick = { onNewsClick(news.id) }
    ) {
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp),
            ) {
                AsyncImage(
                    modifier = Modifier
                        .size(271.dp, 159.dp)
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
                        .padding(top = 10.dp, start = 10.dp),
                    title = news.category,
                )
            }
            Spacer(modifier = Modifier.padding(top = 16.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Image(
                    modifier = Modifier.size(16.dp),
                    painter = painterResource(R.drawable.ic_flash),
                    contentDescription = null,
                )
                Spacer(modifier = Modifier.padding(end = 5.dp))
                Text(
                    text = news.recommended,
                    color = MaterialTheme.colorScheme.onSecondary,
                    style = MaterialTheme.typography.labelMedium,
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = "${news.time} دقیقه قبل ",
                    color = MaterialTheme.colorScheme.onSecondary,
                    style = MaterialTheme.typography.labelMedium,
                )
            }
            Spacer(modifier = Modifier.padding(top = 10.dp))
            Text(
                modifier = Modifier.padding(horizontal = 16.dp),
                text = news.title,
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                style = MaterialTheme.typography.titleMedium,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Justify,
            )
            Spacer(modifier = Modifier.padding(top = 0.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 8.dp),
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
                    Image(
                        painter = painterResource(id = R.drawable.ic_menu),
                        contentDescription = null,
                    )
                }
            }
            Spacer(modifier = Modifier.padding(top = 16.dp))
        }
    }
}