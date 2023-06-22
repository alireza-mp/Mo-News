package ir.alirezamp.discover_datasource.network.mapper

import ir.alirezamp.discover_datasource.network.dto.CategoryDto
import ir.alirezamp.discover_domain.model.Category


fun CategoryDto.mapToDomainModel(): Category {
    return Category(
        id = this.id,
        title = this.title,
    )
}