package ir.alirezamp.news_datasource.ntework.dto

import ir.alirezamp.publisher_datasource.network.dto.PublisherDto
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PublisherNewsDto(
    @SerialName("publisher")
    val publisher: PublisherDto,
    @SerialName("news")
    val news: List<NewsDto>,
)
