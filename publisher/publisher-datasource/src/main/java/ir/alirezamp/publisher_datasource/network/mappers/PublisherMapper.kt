package ir.alirezamp.publisher_datasource.network.mappers

import ir.alirezamp.constats.EndPoints
import ir.alirezamp.publisher_datasource.network.dto.PublisherDto
import ir.alirezamp.publisher_domain.model.Publisher

fun PublisherDto.mapToDomainModel(): Publisher {
    return Publisher(
        categoryId = this.categoryId,
        id = this.id,
        imageUrl = "${EndPoints.BASE_IMAGE_URL}${this.imageUrl}",
        title = this.title,
    )
}