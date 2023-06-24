package ir.alirezamp.constats

object EndPoints {
    // private const val BASE_URL = "http://192.168.1.150/mo_news/"
    private const val BASE_URL = "https://digimoplus.ir/mo_news/"
    private const val BASE_API_URL = "${BASE_URL}api/"
    const val BASE_IMAGE_URL = "${BASE_URL}images/"
    const val NEWS = BASE_API_URL + "news.php" // list of news
    const val PUBLISHER_NEWS = BASE_API_URL + "news_with_publisher.php"
    const val PUBLISHERS = BASE_API_URL + "publishers.php" // list of publishers
    const val DISCOVER_DETAILS = BASE_API_URL + "discover.php" // list of publishers
    const val CATEGORIES = BASE_API_URL + "categories.php" // list of publishers
    fun newsDetail(newsId: String): String = "$BASE_API_URL$newsId/detail.php"
}