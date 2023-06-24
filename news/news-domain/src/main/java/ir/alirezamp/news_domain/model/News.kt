package ir.alirezamp.news_domain.model

import androidx.compose.runtime.Immutable

@Immutable
data class News(
    val id: Int,
    val description: String,
    val category: String,
    val imageUrl: String,
    val publisher: String,
    val publisherImageUrl: String,
    val recommended: String,
    val time: Int,
    val title: String,
)