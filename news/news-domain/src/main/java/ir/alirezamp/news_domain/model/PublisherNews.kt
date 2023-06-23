package ir.alirezamp.news_domain.model

import androidx.compose.runtime.Immutable
import ir.alirezamp.publisher_domain.model.Publisher

@Immutable
data class PublisherNews(
    val publisher: Publisher,
    val news: List<News>,
)
