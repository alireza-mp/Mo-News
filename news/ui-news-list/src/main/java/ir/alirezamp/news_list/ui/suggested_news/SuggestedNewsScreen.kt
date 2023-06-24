package ir.alirezamp.news_list.ui.suggested_news

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
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ir.alirezamp.components.util.ImmutableList
import ir.alirezamp.components.util.alphaAnimation
import ir.alirezamp.components.widget.HorizontalNewsItem
import ir.alirezamp.components.widget.ListTitle
import ir.alirezamp.components.widget.VerticalNewsItem
import ir.alirezamp.designsystem.base.BaseViewModel
import ir.alirezamp.designsystem.util.use
import ir.alirezamp.news_domain.model.News
import kotlinx.coroutines.delay
import org.koin.androidx.compose.koinViewModel

@Stable
@Composable
fun SuggestedNewsScreen(
    viewModel: SuggestedNewsViewModel = koinViewModel(),
    onNavigateToNewsDetailScreen: (newsId: String) -> Unit,
    onProvideBaseViewModel: ((baseViewModel: BaseViewModel) -> Unit)? = null,
) {
    val (state, event) = use(viewModel = viewModel)

    SuggestedNews(state, event, onNavigateToNewsDetailScreen)

    LaunchedEffect(key1 = Unit) {
        onProvideBaseViewModel?.let {
            onProvideBaseViewModel(viewModel)
        }
    }

}


@Composable
private fun SuggestedNews(
    state: SuggestedNewsContract.State,
    event: (SuggestedNewsContract.Event) -> Unit,
    onNavigateToNewsDetailScreen: (newsId: String) -> Unit,
) {
    val onNewsClick =
        remember<(id: Int) -> Unit> { { onNavigateToNewsDetailScreen(it.toString()) } }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {

        // hot news title
        Spacer(modifier = Modifier.padding(top = 4.dp))
        ListTitle(
            Modifier.alphaAnimation(
                enabled = state.isFirstTimeAnimation,
                delay = 250,
                duration = 1000,
            ),
            padding = PaddingValues(horizontal = 16.dp),
            title = "خبر های داغ",
            onClick = {},
        )

        Spacer(modifier = Modifier.padding(top = 8.dp))

        HotNews(
            modifier = Modifier.alphaAnimation(
                enabled = state.isFirstTimeAnimation,
                delay = 500,
                duration = 1000,
            ),
            list = ImmutableList(state.hotNews),
            onItemClick = onNewsClick
        )

        Spacer(modifier = Modifier.padding(top = 8.dp))
        // favorite news title
        ListTitle(
            modifier = Modifier.alphaAnimation(
                enabled = state.isFirstTimeAnimation,
                delay = 750,
                duration = 1000,
            ),
            padding = PaddingValues(horizontal = 16.dp),
            title = "خبر هایی که علاقه داری",
            onClick = {},
        )

        Spacer(modifier = Modifier.padding(top = 8.dp))

        FavoriteNews(
            modifier = Modifier.alphaAnimation(
                enabled = state.isFirstTimeAnimation,
                delay = 1000,
                duration = 1000,
            ), list = ImmutableList(state.favoriteNews),
            onItemClick = onNewsClick
        )

    }

    // disable first launch animation
    LaunchedEffect(state.isFirstTimeAnimation) {
        delay(2000)
        event(SuggestedNewsContract.Event.DisableFirstTimeAnimation)
    }
}

@Stable
@Composable
fun HotNews(
    modifier: Modifier = Modifier,
    list: ImmutableList<News>,
    onItemClick: (Int) -> Unit,
) {
    LazyRow(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 16.dp)
    ) {
        itemsIndexed(items = list.items, key = { _, item -> item.id }) { _, item ->
            VerticalNewsItem(
                news = item,
                onNewsClick = onItemClick,
            )
        }
    }
}

@Stable
@Composable
fun FavoriteNews(
    modifier: Modifier = Modifier,
    list: ImmutableList<News>,
    onItemClick: (Int) -> Unit,
) {
    list.items.forEachIndexed { _, item ->
        HorizontalNewsItem(
            modifier = modifier,
            news = item,
            onItemClick = onItemClick,
        )
    }
}


