package ir.alirezamp.navigation.graph

import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import ir.alirezamp.designsystem.base.BaseViewModel
import ir.alirezamp.navigation.Destinations
import ir.alirezamp.navigation.extension_function.navigate
import ir.alirezamp.news_list.ui.NewsRoute

fun NavGraphBuilder.newsList(
    navController: NavController,
    onProvideBaseViewModel: (baseViewModel: BaseViewModel) -> Unit,
) {

    composable(Destinations.NewsListScreen.route) {
        NewsRoute(
            onNavigateToNewsDetailScreen = { newsId ->
                navController.navigate(
                    route = Destinations.NewsDetailScreen().route,
                    args = bundleOf(Destinations.NewsDetailScreen().newsId to newsId)
                )
            },
            onNavigateToPublisherDetailScreen = { publisherId ->
                navController.navigate(
                    route = Destinations.PublisherDetailScreen().route,
                    args = bundleOf(Destinations.PublisherDetailScreen().publisherId to publisherId)
                )
            },
            onProvideBaseViewModel = {
                onProvideBaseViewModel(it)
            }
        )
    }

}