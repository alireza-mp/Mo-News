package ir.alirezamp.publisher_datasource.network.service

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.HttpStatusCode
import ir.alirezamp.constats.EndPoints
import ir.alirezamp.publisher_datasource.network.dto.PublisherDto

class PublisherDatasourceImpl(
    private val client: HttpClient,
) : PublisherDatasource {
    override suspend fun getPublishers(): List<PublisherDto>? {
        return try {
            val response = client.get(EndPoints.PUBLISHERS)
            if (response.status == HttpStatusCode.OK) {
                return response.body()
            } else null
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}