package ir.alirezamp.news_datasource.ntework.mappers

import ir.alirezamp.constats.EndPoints
import ir.alirezamp.news_datasource.ntework.dto.NewsDetailDto
import ir.alirezamp.news_domain.model.NewsDetail

fun NewsDetailDto.mapToDomainModel(): NewsDetail {
    return NewsDetail(
        body = this.body,
        description = this.description,
        chips = this.chips,
        id = this.id,
        imageUrl = "${EndPoints.BASE_IMAGE_URL}${this.imageUrl}",
        publisher = this.publisher,
        publisherImageUrl = "${EndPoints.BASE_IMAGE_URL}${this.publisherImageUrl}",
        recommended = this.recommended,
        time = this.time,
        title = this.title,
    )
}