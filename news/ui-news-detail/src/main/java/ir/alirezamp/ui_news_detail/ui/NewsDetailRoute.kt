package ir.alirezamp.ui_news_detail.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.Stable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ir.alirezamp.components.PublisherChips
import ir.alirezamp.components.util.IconButton
import ir.alirezamp.components.util.ImmutableList
import ir.alirezamp.components.util.alphaAnimation
import ir.alirezamp.components.util.offsetYAnimation
import ir.alirezamp.components.widget.CardIndicator
import ir.alirezamp.components.widget.Chips
import ir.alirezamp.components.widget.RemoteImage
import ir.alirezamp.designsystem.base.BaseViewModel
import ir.alirezamp.designsystem.theme.cardTopRoundedCorner
import ir.alirezamp.designsystem.util.use
import ir.alirezamp.ui_news_detail.R
import kotlinx.coroutines.delay
import org.koin.androidx.compose.koinViewModel

@Composable
fun NewsDetailRoute(
    newsId: String,
    viewModel: NewsDetailViewModel = koinViewModel(),
    onProvideBaseViewModel: (baseViewModel: BaseViewModel) -> Unit,
) {
    val (state, event) = use(viewModel = viewModel)

    NewsDetailScreen(newsId = newsId, state = state, event = event)

    LaunchedEffect(key1 = Unit) {
        onProvideBaseViewModel(viewModel)
    }
}

@Stable
@Composable
private fun NewsDetailScreen(
    newsId: String,
    state: NewsDetailContract.State,
    event: (NewsDetailContract.Event) -> Unit,
) {

    LaunchedEffect(key1 = Unit) {
        event(NewsDetailContract.Event.GetNewsDetail(newsId))
    }

    state.newsDetail?.let { newsDetail ->

        Box(modifier = Modifier.fillMaxSize()) {
            RemoteImage(
                imageUrl = newsDetail.imageUrl,
                modifier = Modifier
                    .alphaAnimation(
                        state.isFirstTimeAnimation,
                        delay = 300,
                        duration = 1300
                    )
                    .fillMaxWidth()
                    .height(330.dp),
                contentScale = ContentScale.FillBounds,
            )
            Row(
                modifier = Modifier
                    .alphaAnimation(
                        state.isFirstTimeAnimation,
                        delay = 300,
                        duration = 1300
                    )
                    .fillMaxWidth()
                    .align(Alignment.TopCenter)
                    .padding(top = 12.dp, end = 16.dp, start = 16.dp),
                horizontalArrangement = Arrangement.Center,
            ) {
                IconButton(onClick = { }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_arrow_right),
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.surfaceTint,
                    )
                }
                Spacer(modifier = Modifier.weight(1f))
                IconButton(onClick = { }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_bookmark),
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.surfaceTint,
                    )
                }
                Spacer(modifier = Modifier.padding(end = 24.dp))
                IconButton(onClick = { }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_vertical_menu),
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.surfaceTint,
                    )
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState()),
            ) {
                Spacer(modifier = Modifier.padding(top = 290.dp))
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .offsetYAnimation(
                            state.isFirstTimeAnimation,
                            delay = 0,
                            duration = 800,
                            startOffset = 400.dp,
                            endOffset = 0.dp
                        ),
                    shape = MaterialTheme.shapes.cardTopRoundedCorner,
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondary),
                ) {
                    Column(
                        Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp),
                        verticalArrangement = Arrangement.Center
                    ) {
                        Spacer(modifier = Modifier.padding(top = 8.dp))
                        Box(
                            modifier = Modifier.fillMaxWidth(),
                            contentAlignment = Alignment.Center
                        ) {
                            CardIndicator()
                        }
                        Spacer(modifier = Modifier.padding(top = 20.dp))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Image(
                                    painter = painterResource(id = ir.alirezamp.components.R.drawable.ic_flash),
                                    contentDescription = null,
                                )
                                Spacer(modifier = Modifier.padding(end = 5.dp))
                                Text(
                                    text = newsDetail.recommended,
                                    color = MaterialTheme.colorScheme.onSecondaryContainer,
                                    style = MaterialTheme.typography.labelMedium,
                                )
                            }

                            PublisherChips(
                                imageUrl = newsDetail.publisherImageUrl,
                                title = newsDetail.publisher,
                            )

                            Text(
                                text = "${newsDetail.time} دقیقه قبل ",
                                color = MaterialTheme.colorScheme.onSecondaryContainer,
                                style = MaterialTheme.typography.labelMedium,
                            )
                        }
                        Spacer(modifier = Modifier.padding(top = 32.dp))
                        Text(
                            text = newsDetail.title,
                            modifier = Modifier.fillMaxWidth(),
                            color = MaterialTheme.colorScheme.onSecondaryContainer,
                            style = MaterialTheme.typography.headlineLarge,
                            textAlign = TextAlign.Justify,
                            lineHeight = 30.sp,
                        )
                        Spacer(modifier = Modifier.padding(top = 20.dp))
                        ChipsList(ImmutableList(newsDetail.chips))
                        Spacer(modifier = Modifier.padding(top = 20.dp))
                        Text(
                            text = newsDetail.description,
                            modifier = Modifier.fillMaxWidth(),
                            color = MaterialTheme.colorScheme.onSecondaryContainer,
                            style = MaterialTheme.typography.headlineMedium,
                            textAlign = TextAlign.Justify,
                            lineHeight = 25.sp,
                        )
                        Spacer(modifier = Modifier.padding(top = 20.dp))
                        Text(
                            text = newsDetail.body,
                            modifier = Modifier.fillMaxWidth(),
                            color = MaterialTheme.colorScheme.onSecondaryContainer,
                            style = MaterialTheme.typography.bodyLarge,
                            textAlign = TextAlign.Justify,
                            lineHeight = 22.sp,
                        )
                        Spacer(modifier = Modifier.padding(top = 20.dp))
                    }
                }
            }
        }
        LaunchedEffect(key1 = state.isFirstTimeAnimation) {
            delay(1600)
            event(NewsDetailContract.Event.DisableFirstTimeAnimation)
        }
    }
}

@Stable
@Composable
private fun ChipsList(list: ImmutableList<String>) {
    LazyRow(modifier = Modifier.fillMaxWidth()) {
        itemsIndexed(items = list.items, key = { index, _ -> index }) { _, item ->
            Chips(
                modifier = Modifier.padding(end = 15.dp),
                title = item,
                enabled = true,
                onClick = {}
            )
        }
    }
}

