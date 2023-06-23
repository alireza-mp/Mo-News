package ir.alirezamp.news_domain.model

import androidx.compose.runtime.Immutable

@Immutable
data class NewsDetail(
    val body: String,
    val chips: List<String>,
    val description: String,
    val id: Int,
    val imageUrl: String,
    val publisher: String,
    val publisherImageUrl: String,
    val recommended: String,
    val time: Double,
    val title: String,
)
