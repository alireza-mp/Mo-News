package ir.alirezamp.navigation.graph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import ir.alirezamp.designsystem.base.BaseViewModel
import ir.alirezamp.navigation.Destinations
import ir.alirezamp.ui_discover_details.ui.DiscoverRoute

fun NavGraphBuilder.discover(
    navController: NavController,
    onProvideBaseViewModel: (baseViewModel: BaseViewModel) -> Unit,
) {

    composable(Destinations.DiscoverScreen.route) {
        DiscoverRoute(
            onNavigateToNewsDetailScreen = { newsId ->
                navController.navigate(
                    Destinations.NewsDetailScreen()
                        .createNewsIdRoute(
                            newsId = newsId
                        )
                )
            },
            onProvideBaseViewModel = {
                onProvideBaseViewModel(it)
            }
        )
    }

}