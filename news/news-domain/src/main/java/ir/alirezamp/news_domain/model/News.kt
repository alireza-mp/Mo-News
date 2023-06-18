package ir.alirezamp.news_domain.model

data class News(
    val id: Int,
    val newsId: Int,
    val description: String,
    val category: String,
    val imageUrl: String,
    val publisher: String,
    val publisherImageUrl: String,
    val recommended: String,
    val time: String,
    val title: String,
)