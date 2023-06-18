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
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ir.alirezamp.designsystem.base.BaseViewModel
import ir.alirezamp.designsystem.use
import ir.alirezamp.news_list.components.ListTitle
import kotlinx.coroutines.delay
import org.koin.androidx.compose.koinViewModel

@Composable
fun SuggestedNewsScreen(
    viewModel: SuggestedNewsViewModel = koinViewModel(),
    onNavigateToNewsDetailScreen: (newsId: String) -> Unit,
    onProvideBaseViewModel: (baseViewModel: BaseViewModel) -> Unit,
) {
    val (state, event) = use(viewModel = viewModel)

    SuggestedNews(rNewsState = state)

    LaunchedEffect(key1 = Unit) {
        onProvideBaseViewModel(viewModel)
    }

}


@Composable
private fun SuggestedNews(
    rNewsState: SuggestedNewsContract.State,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {

        // hot news title
        Spacer(modifier = Modifier.padding(top = 4.dp))
        ListTitle(
            /* Modifier.alphaAnimation(
                 enabled = viewModel.isLaunchAnimation,
                 delay = 250,
                 duration = 1000,
             ),*/
            padding = PaddingValues(horizontal = 16.dp),
            title = "خبر های داغ",
            onClick = {},
        )

        Spacer(modifier = Modifier.padding(top = 8.dp))

        // hot news list
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
            itemsIndexed(items = rNewsState.hotNews, key = { _, item -> item.id }) { _, item ->
                /*    HotNewsItem(
                        model = item,
                        onClick = {
                            // navigate to news detail page
                            navHostController.navigate(
                                BottomNavigationScreens.NewsDetail.createNewsIdRoute(
                                    newsId = item.newsId.toString(),
                                ),
                            )
                        }
                    )*/
            }
        }

        Spacer(modifier = Modifier.padding(top = 8.dp))
        // favorite news title
        ListTitle(
            /*   modifier = Modifier.alphaAnimation(
                   enabled = viewModel.isLaunchAnimation,
                   delay = 750,
                   duration = 1000,
               ),*/
            padding = PaddingValues(horizontal = 16.dp),
            title = "خبر هایی که علاقه داری",
            onClick = {},
        )
        Spacer(modifier = Modifier.padding(top = 8.dp))

        // favorite news list
        rNewsState.favoriteNews.forEachIndexed { _, item ->
            /*     FavoriteNewsItem(
                     modifier = Modifier.padding(horizontal = 16.dp)
                         .alphaAnimation(
                             enabled = viewModel.isLaunchAnimation,
                             delay = 1000,
                             duration = 1000,
                         ),
                     model = item,
                     onClick = {
                         // navigate to news detail page
                         navHostController.navigate(
                             BottomNavigationScreens.NewsDetail.createNewsIdRoute(
                                 newsId = item.newsId.toString(),
                             ),
                         )
                     }
                 )*/
        }

    }

    // disable first launch animation
    LaunchedEffect(Unit) {
        delay(1200)
        //  viewModel.isLaunchAnimation = false
    }
}


