@file:OptIn(ExperimentalFoundationApi::class)

package ir.alirezamp.news_list.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ir.alirezamp.components.util.TabState
import ir.alirezamp.components.widget.TabRow
import ir.alirezamp.designsystem.base.BaseViewModel
import ir.alirezamp.news_list.ui.flowing_news.FlowingNewsScreen
import ir.alirezamp.news_list.ui.suggested_news.SuggestedNewsScreen
import kotlinx.coroutines.launch

@Composable
fun NewsRoute(
    onNavigateToNewsDetailScreen: (newsId: String) -> Unit,
    onProvideBaseViewModel: (baseViewModel: BaseViewModel) -> Unit,
) {
    NewsScreen(
        onNavigateToNewsDetailScreen,
        onProvideBaseViewModel,
    )

}

@Composable
private fun NewsScreen(
    onNavigateToNewsDetailScreen: (newsId: String) -> Unit,
    onProvideBaseViewModel: (baseViewModel: BaseViewModel) -> Unit,
) {
    val tabState = remember { mutableStateOf(TabState.Suggested) }
    val pagerState = rememberPagerState()
    val coroutineScope = rememberCoroutineScope()
    // header
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.surface)
    ) {
        Spacer(modifier = Modifier.padding(top = 16.dp))
        // tab row
        TabRow(
            modifier = Modifier.padding(horizontal = 16.dp),
            tabState = tabState.value,
            onTabClick = { index ->
                coroutineScope.launch {
                    pagerState.animateScrollToPage(index)
                }
            },
        )

        Spacer(modifier = Modifier.padding(top = 12.dp))
        // pager
        HorizontalPager(
            modifier = Modifier.fillMaxSize(),
            pageCount = 2,
            state = pagerState,
        ) { page ->
            when (page) {
                0 -> {
                    SuggestedNewsScreen(
                        onNavigateToNewsDetailScreen = onNavigateToNewsDetailScreen,
                        onProvideBaseViewModel = onProvideBaseViewModel,
                    )
                }

                1 -> {
                    FlowingNewsScreen(
                        onNavigateToNewsDetailScreen = onNavigateToNewsDetailScreen,
                        onProvideBaseViewModel = onProvideBaseViewModel,
                    )
                }
            }
        }
        // update tabRow state when page scrolled
        LaunchedEffect(pagerState.currentPage) {
            if (pagerState.currentPage == 0) {
                tabState.value = TabState.Suggested
            } else {
                tabState.value = TabState.Flowing
            }
        }
    }
}
