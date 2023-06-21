package ir.alirezamp.news_datasource.ntework.mappers

import ir.alirezamp.news_datasource.ntework.dto.PublisherNewsDto
import ir.alirezamp.news_domain.model.PublisherNews
import ir.alirezamp.publisher_datasource.network.mappers.mapToDomainModel

fun PublisherNewsDto.mapToDomainModel(): PublisherNews {
    return PublisherNews(
        publisher = this.publisher.mapToDomainModel(),
        news = this.news.map { it.mapToDomainModel() },
    )
}