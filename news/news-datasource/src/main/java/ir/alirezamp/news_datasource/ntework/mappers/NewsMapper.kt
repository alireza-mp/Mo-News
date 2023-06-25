package ir.alirezamp.news_datasource.ntework.mappers

import ir.alirezamp.constats.EndPoints
import ir.alirezamp.news_datasource.ntework.dto.NewsDto
import ir.alirezamp.news_domain.model.News

fun NewsDto.mapToDomainModel(): News {
    return News(
        id = this.id,
        description = this.description,
        category = this.category,
        imageUrl = "${EndPoints.BASE_IMAGE_URL}${this.imageUrl}",
        publisher = this.publisher,
        publisherImageUrl = "${EndPoints.BASE_IMAGE_URL}${this.publisherImageUrl}",
        recommended = this.recommended,
        time = this.time,
        title = this.title,
    )
}