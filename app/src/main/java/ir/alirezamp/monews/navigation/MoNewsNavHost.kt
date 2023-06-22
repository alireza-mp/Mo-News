package ir.alirezamp.monews.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import ir.alirezamp.designsystem.base.BaseViewModel
import ir.alirezamp.navigation.Destinations
import ir.alirezamp.navigation.graph.discover
import ir.alirezamp.navigation.graph.news


@Composable
fun MoNewsNavHost(
    navController: NavHostController,
    modifier: Modifier,
    onProvideBaseViewModel: (baseViewModel: BaseViewModel) -> Unit,
) {
    NavHost(
        navController = navController,
        startDestination = Destinations.NewsListScreen.route,
        modifier = modifier,
    ) {
        news(navController, onProvideBaseViewModel)
        discover(navController, onProvideBaseViewModel)
        /* favoriteNews(navController, onProvideBaseViewModel)
         newsDetail(onProvideBaseViewModel)*/
    }
}