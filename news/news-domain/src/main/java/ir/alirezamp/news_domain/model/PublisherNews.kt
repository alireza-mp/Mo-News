package ir.alirezamp.news_domain.model

import ir.alirezamp.publisher_domain.model.Publisher

data class PublisherNews(
    val publisher: Publisher,
    val news: List<News>,
)
