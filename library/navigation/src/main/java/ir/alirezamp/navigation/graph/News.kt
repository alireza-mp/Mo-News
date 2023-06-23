package ir.alirezamp.navigation.graph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import ir.alirezamp.designsystem.base.BaseViewModel
import ir.alirezamp.navigation.Destinations
import ir.alirezamp.news_list.ui.NewsRoute

fun NavGraphBuilder.news(
    navController: NavController,
    onProvideBaseViewModel: (baseViewModel: BaseViewModel) -> Unit,
) {

    composable(Destinations.NewsListScreen.route) {
        NewsRoute(
            onNavigateToNewsDetailScreen = { newsId ->
                navController.navigate(
                    Destinations.NewsDetailScreen()
                        .createNewsIdRoute(
                            newsId = newsId,
                        )
                )
            },
            onNavigateToPublisherDetailScreen = { publisherId ->
                navController.navigate(
                    Destinations.PublisherDetailScreen()
                        .createPublisherIdRoute(
                            publisherId = publisherId,
                        )
                )
            },
            onProvideBaseViewModel = {
                onProvideBaseViewModel(it)
            }
        )
    }

}