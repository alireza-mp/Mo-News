package ir.alirezamp.news_datasource.ntework.service

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.http.HttpStatusCode
import ir.alirezamp.constats.EndPoints
import ir.alirezamp.news_datasource.ntework.dto.NewsDto
import ir.alirezamp.news_datasource.ntework.dto.PublisherNewsDto
import kotlinx.coroutines.delay

class NewsServiceImpl(
    private val client: HttpClient,
) : NewsService {

    override suspend fun getHotNews(): List<NewsDto>? {
        delay(2000)
        return try {
            val result = client.get(EndPoints.NEWS) {
                parameter("filter", "Hot")
            }
            if (result.status == HttpStatusCode.OK) {
                return result.body<List<NewsDto>>()
            } else null
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    override suspend fun getFavoriteNews(): List<NewsDto>? {
        return try {
            val result = client.get(EndPoints.NEWS) {
                parameter("filter", "Favorite")
            }
            if (result.status == HttpStatusCode.OK) {
                return result.body<List<NewsDto>>()
            } else null
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    override suspend fun getEditorSuggestionNews(): List<NewsDto>? {
        return try {
            val result = client.get(EndPoints.NEWS) {
                parameter("filter", "EditorSuggestion")
            }
            if (result.status == HttpStatusCode.OK) {
                return result.body<List<NewsDto>>()
            } else null
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    override suspend fun getPublisherNews(): List<PublisherNewsDto>? {
        return try {
            val result = client.get(EndPoints.PUBLISHER_NEWS)
            if (result.status == HttpStatusCode.OK) {
                return result.body<List<PublisherNewsDto>>()
            } else null
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}