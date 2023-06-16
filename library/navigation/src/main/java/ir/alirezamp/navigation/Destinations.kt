package ir.alirezamp.navigation

sealed class Destinations(
    val route: String,
    val enabledBottomNavigationRoute: String = route,
) {
    object NewsListScreen : Destinations("news_list_screen")
    data class NewsDetailScreen(val newsId: String = "news") : Destinations(
        "news_detail_screen",
        NewsListScreen.route,
    )

    object FavoriteNewsScreen : Destinations("favorite_news_screen")
}

// find destination by route
fun String.findDestinations(): Destinations? {
    return when (this) {
        Destinations.NewsListScreen.route -> Destinations.NewsListScreen//
        Destinations.FavoriteNewsScreen.route -> Destinations.NewsListScreen//
        Destinations.NewsDetailScreen().route -> Destinations.NewsListScreen//
        else -> null
    }
}