package ir.alirezamp.news_datasource.ntework.service

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.http.HttpStatusCode
import io.ktor.http.appendPathSegments
import ir.alirezamp.constats.EndPoints
import ir.alirezamp.constats.NetworkParams
import ir.alirezamp.news_datasource.ntework.dto.NewsDetailDto
import ir.alirezamp.news_datasource.ntework.dto.NewsDto
import ir.alirezamp.news_datasource.ntework.dto.PublisherNewsDto

class NewsServiceImpl(
    private val client: HttpClient,
) : NewsService {

    override suspend fun getHotNews(filter: String): List<NewsDto>? {
        return try {
            val result = client.get(EndPoints.NEWS) {
                parameter(NetworkParams.FILTER, filter)
            }
            if (result.status == HttpStatusCode.OK) {
                return result.body<List<NewsDto>>()
            } else null
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    override suspend fun getFavoriteNews(filter: String): List<NewsDto>? {
        return try {
            val result = client.get(EndPoints.NEWS) {
                parameter(NetworkParams.FILTER, filter)
            }
            if (result.status == HttpStatusCode.OK) {
                return result.body<List<NewsDto>>()
            } else null
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    override suspend fun getEditorSuggestionNews(filter: String): List<NewsDto>? {
        return try {
            val result = client.get(EndPoints.NEWS) {
                parameter(NetworkParams.FILTER, filter)
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

    override suspend fun getNewsDetail(newsId: String): NewsDetailDto? {
        return try {
            val result = client.get(EndPoints.BASE_API_URL) {
                url {
                    appendPathSegments(newsId, EndPoints.NEWS_DETAIL)
                }
            }
            if (result.status == HttpStatusCode.OK) {
                return result.body<NewsDetailDto>()
            } else null
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}