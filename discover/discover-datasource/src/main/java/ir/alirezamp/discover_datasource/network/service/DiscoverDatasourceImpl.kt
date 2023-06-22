package ir.alirezamp.discover_datasource.network.service

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.HttpStatusCode
import ir.alirezamp.constats.EndPoints
import ir.alirezamp.discover_datasource.network.dto.CategoryDto
import ir.alirezamp.discover_datasource.network.dto.DiscoverDetailDto

class DiscoverDatasourceImpl(
    private val client: HttpClient,
) : DiscoverDatasource {
    override suspend fun getDiscoverDetails(): DiscoverDetailDto? {
        return try {
            val response = client.get(EndPoints.DISCOVER_DETAILS)
            if (response.status == HttpStatusCode.OK) {
                response.body<DiscoverDetailDto>()
            } else null
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    override suspend fun getCategories(): List<CategoryDto>? {
        return try {
            val response = client.get(EndPoints.CATEGORIES)
            if (response.status == HttpStatusCode.OK) {
                response.body<List<CategoryDto>>()
            } else null
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}