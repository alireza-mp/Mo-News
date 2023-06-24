package ir.alirezamp.discover_datasource.network.mapper

import ir.alirezamp.constats.EndPoints
import ir.alirezamp.discover_datasource.network.dto.DiscoverDetailDto
import ir.alirezamp.discover_domain.model.DiscoverDetail


fun DiscoverDetailDto.mapToDomainModel(): DiscoverDetail {
    return DiscoverDetail(
        banners = this.banners.map { "${EndPoints.BASE_IMAGE_URL}$it" },
        subtitle = this.subtitle,
    )
}
