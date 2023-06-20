package ir.alirezamp.news_datasource.ntework.mappers

import ir.alirezamp.news_datasource.ntework.dto.NewsDto
import ir.alirezamp.news_domain.model.News

fun NewsDto.mapToDomainModel(): News {
    return News(
        id = this.id,
        description = this.description,
        category = this.category,
        imageUrl = this.imageUrl,
        publisher = this.publisher,
        publisherImageUrl = this.publisherImageUrl,
        recommended = this.recommended,
        time = this.time.toString(),
        title = this.title,
    )
}