package ir.alirezamp.navigation.graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import ir.alirezamp.designsystem.base.BaseViewModel
import ir.alirezamp.navigation.Destinations
import ir.alirezamp.ui_news_detail.ui.NewsDetailRoute

fun NavGraphBuilder.newsDetail(
    onProvideBaseViewModel: (baseViewModel: BaseViewModel) -> Unit,
) {

    composable(Destinations.NewsDetailScreen().route) { entry ->
        NewsDetailRoute(
            newsId = entry.arguments?.getString("newsId") ?: "1",
            onProvideBaseViewModel = onProvideBaseViewModel
        )
    }

}