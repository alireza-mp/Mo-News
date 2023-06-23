package ir.alirezamp.navigation

sealed class Destinations(
    val route: String,
    val enabledBottomNavigationRoute: String = route,
) {
    object NewsListScreen : Destinations("news_list_screen")
    object DiscoverScreen : Destinations("discover_screen")
    class NewsDetailScreen : Destinations(
        "news_detail_screen/{newsId}",
        NewsListScreen.route,
    ) {
        fun createNewsIdRoute(newsId: String): String = "news_detail_screen/$newsId"
    }

    class PublisherDetailScreen : Destinations(
        "publisher_detail_screen/{publisherId}",
        NewsListScreen.route,
    ) {
        fun createPublisherIdRoute(publisherId: String): String =
            "publisher_detail_screen/$publisherId"
    }

    object FavoriteNewsScreen : Destinations("favorite_news_screen")
}

// find destination by route
fun String.findDestinations(): Destinations? {
    return when (this) {
        Destinations.NewsListScreen.route -> Destinations.NewsListScreen
        Destinations.DiscoverScreen.route -> Destinations.DiscoverScreen
        Destinations.FavoriteNewsScreen.route -> Destinations.NewsListScreen
        Destinations.NewsDetailScreen().route -> Destinations.NewsListScreen
        Destinations.PublisherDetailScreen().route -> Destinations.NewsListScreen
        else -> null
    }
}