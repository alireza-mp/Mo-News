@file:OptIn(ExperimentalFoundationApi::class)

package ir.alirezamp.ui_discover_details.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
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
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ir.alirezamp.components.util.AppBarAction
import ir.alirezamp.components.util.ImmutableList
import ir.alirezamp.components.widget.AppBar
import ir.alirezamp.components.widget.Chips
import ir.alirezamp.components.widget.ListTitle
import ir.alirezamp.components.widget.PublisherItem
import ir.alirezamp.components.widget.VerticalNewsItem
import ir.alirezamp.designsystem.base.BaseViewModel
import ir.alirezamp.designsystem.util.use
import ir.alirezamp.discover_domain.model.Category
import ir.alirezamp.news_domain.model.News
import ir.alirezamp.publisher_domain.model.Publisher
import ir.alirezamp.ui_discover_details.components.AutoSubtitle
import ir.alirezamp.ui_discover_details.components.Slider
import org.koin.androidx.compose.koinViewModel

@Stable
@Composable
fun DiscoverRoute(
    viewModel: DiscoverViewModel = koinViewModel(),
    onNavigateToNewsDetailScreen: (newsId: String) -> Unit,
    onProvideBaseViewModel: (baseViewModel: BaseViewModel) -> Unit,
) {
    val (state, event) = use(viewModel)

    LaunchedEffect(key1 = Unit) {
        onProvideBaseViewModel(viewModel)
    }

    DiscoverScreen(
        state = state,
        event = event,
        onNavigateToNewsDetailScreen,
    )
}

@Stable
@Composable
private fun DiscoverScreen(
    state: DiscoverContract.State,
    event: (DiscoverContract.Event) -> Unit,
    onNavigateToNewsDetailScreen: (newsId: String) -> Unit,
) {
    val onCategoryClick =
        remember<(Int) -> Unit> { { event(DiscoverContract.Event.OnCategoryClick(it)) } }
    val onPublisherClick =
        remember<(id: Int, state: Boolean) -> Unit> {
            { id, state -> event(DiscoverContract.Event.ChangePublisherFlowing(id, state)) }
        }
    val onNewsClick = remember<(Int) -> Unit> { { onNavigateToNewsDetailScreen(it.toString()) } }
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = MaterialTheme.colorScheme.surface)
                .verticalScroll(rememberScrollState())
        ) {
            AppBar(
                actions = ImmutableList(listOf(AppBarAction.SEARCH, AppBarAction.FILTER)),
                onClick = {})
            Spacer(modifier = Modifier.padding(top = 12.dp))
            Slider(
                padding = PaddingValues(horizontal = 16.dp),
                imagesUrls = ImmutableList(state.discoverDetail?.banners ?: emptyList()),
            )
            Spacer(modifier = Modifier.padding(top = 24.dp))
            Categories(
                list = ImmutableList(state.categories),
                enabledId = state.selectedCategoryId,
                onItemClick = onCategoryClick
            )
            Spacer(modifier = Modifier.padding(top = 24.dp))
            ListTitle(
                padding = PaddingValues(horizontal = 16.dp),
                title = "خبرگذاری ها",
                onClick = {}
            )
            Spacer(modifier = Modifier.padding(top = 24.dp))
            Publishers(list = ImmutableList(state.publishers), onItemClick = onPublisherClick)
            Spacer(modifier = Modifier.padding(top = 24.dp))
            ListTitle(
                padding = PaddingValues(horizontal = 16.dp),
                title = "پیشنهاد سردبیر",
                onClick = {}
            )
            Spacer(modifier = Modifier.padding(top = 20.dp))
            NewsList(list = ImmutableList(state.news), onItemClick = onNewsClick)
            Spacer(modifier = Modifier.padding(bottom = 58.dp))
        }
        AutoSubtitle(
            modifier = Modifier.align(Alignment.BottomCenter),
            visible = true,
            text = state.discoverDetail?.subtitle ?: "",
        )
    }
}

@Stable
@Composable
private fun Categories(
    list: ImmutableList<Category>,
    enabledId: Int,
    onItemClick: (Int) -> Unit,
) {
    LazyRow(
        modifier = Modifier
            .padding(start = 16.dp)
            .fillMaxWidth()
    ) {
        itemsIndexed(items = list.items, key = { _, item -> item.id }) { _, item ->
            Chips(
                modifier = Modifier.padding(end = 16.dp),
                title = item.title,
                enabled = enabledId == item.id,
                onClick = { onItemClick(item.id) }
            )
        }
    }
}

@Stable
@Composable
private fun NewsList(
    list: ImmutableList<News>,
    onItemClick: (Int) -> Unit,
) {
    LazyRow(
        modifier = Modifier
            .padding(start = 16.dp)
            .fillMaxWidth(),
    ) {
        itemsIndexed(items = list.items) { _, item ->
            VerticalNewsItem(
                news = item,
                onNewsClick = onItemClick,
            )
        }
    }
}


@Stable
@Composable
private fun Publishers(
    list: ImmutableList<Publisher>,
    onItemClick: (id: Int, state: Boolean) -> Unit,
) {
    LazyRow(
        modifier = Modifier
            .padding(start = 16.dp)
            .fillMaxWidth()
    ) {
        itemsIndexed(
            items = list.items,
            key = { _, item -> item.id }) { _, item ->
            PublisherItem(
                modifier = Modifier
                    .padding(end = 20.dp)
                    .animateItemPlacement(),
                publisher = item,
                onItemClick = onItemClick
            )
        }
    }
}


