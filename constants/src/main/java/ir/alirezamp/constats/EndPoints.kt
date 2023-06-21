package ir.alirezamp.constats

object EndPoints {
    const val BASE_URL = "http://192.168.1.150/mobo/"
    private const val BASE_API_URL = "http://192.168.1.150/mobo/api/"
    const val NEWS = BASE_API_URL + "news.php" // list of news
    const val PublisherNews =
        BASE_API_URL + "news_with_publisher.php" // list of news with publishers
    const val Publishers = BASE_API_URL + "publishers.php" // list of publishers
}