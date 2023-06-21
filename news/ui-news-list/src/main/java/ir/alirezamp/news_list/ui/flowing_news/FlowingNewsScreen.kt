package ir.alirezamp.news_list.ui.flowing_news

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ir.alirezamp.components.widget.VerticalNewsItem
import ir.alirezamp.designsystem.base.BaseViewModel
import ir.alirezamp.designsystem.util.use
import ir.alirezamp.news_list.components.PublisherTitle
import org.koin.androidx.compose.koinViewModel

@Composable
fun FlowingNewsScreen(
    viewModel: FlowingNewsViewModel = koinViewModel(),
    onNavigateToNewsDetailScreen: (newsId: String) -> Unit,
    onNavigateToPublisherDetailScreen: (publisherId: String) -> Unit,
    onProvideBaseViewModel: ((baseViewModel: BaseViewModel) -> Unit)? = null,
) {

    val (state, event) = use(viewModel = viewModel)

    FlowingNews(
        state = state,
        event = event,
        onNavigateToNewsDetailScreen = onNavigateToNewsDetailScreen,
        onNavigateToPublisherDetailScreen = onNavigateToPublisherDetailScreen,
    )

    LaunchedEffect(key1 = Unit) {
        onProvideBaseViewModel?.let {
            onProvideBaseViewModel(viewModel)
        }
    }
}

@Composable
private fun FlowingNews(
    state: FlowingNewsContract.State,
    event: (FlowingNewsContract.Event) -> Unit,
    onNavigateToNewsDetailScreen: (newsId: String) -> Unit,
    onNavigateToPublisherDetailScreen: (publisherId: String) -> Unit,
) {

    LaunchedEffect(key1 = Unit) {
        event(FlowingNewsContract.Event.getPbulisherNewsList)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {

        state.publisherNews.forEach { publisherNews ->
            //title
            Spacer(modifier = Modifier.padding(top = 4.dp))
            PublisherTitle(
                /* Modifier.alphaAnimation(
                     enabled = viewModel.isLaunchAnimation,
                     delay = 250,
                     duration = 1000,
                 ),*/
                padding = PaddingValues(horizontal = 16.dp),
                title = publisherNews.publisher.title,
                imageUrl = publisherNews.publisher.imageUrl,
                onClick = {
                    onNavigateToPublisherDetailScreen(publisherNews.publisher.id.toString())
                },
            )

            Spacer(modifier = Modifier.padding(top = 8.dp))

            // news list
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    /*     .alphaAnimation(
                             enabled = viewModel.isLaunchAnimation,
                             delay = 500,
                             duration = 1000,
                         )*/
                    .padding(start = 16.dp)
            ) {
                itemsIndexed(items = publisherNews.news) { _, item ->
                    VerticalNewsItem(
                        news = item,
                        onNewsClick = { newsId ->
                            onNavigateToNewsDetailScreen(newsId.toString())
                        },
                    )
                }
            }
            Spacer(modifier = Modifier.padding(top = 8.dp))
        }

    }
}