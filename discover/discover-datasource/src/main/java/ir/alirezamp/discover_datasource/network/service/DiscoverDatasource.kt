package ir.alirezamp.discover_datasource.network.service

import ir.alirezamp.discover_datasource.network.dto.CategoryDto
import ir.alirezamp.discover_datasource.network.dto.DiscoverDetailDto

interface DiscoverDatasource {


    suspend fun getDiscoverDetails(): DiscoverDetailDto?

    suspend fun getCategories(): List<CategoryDto>?

}