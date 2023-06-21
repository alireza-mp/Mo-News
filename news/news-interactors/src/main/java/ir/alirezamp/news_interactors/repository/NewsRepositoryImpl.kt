package ir.alirezamp.news_interactors.repository

import ir.alirezamp.core.domain.DataState
import ir.alirezamp.news_datasource.ntework.mappers.mapToDomainModel
import ir.alirezamp.news_datasource.ntework.service.NewsService
import ir.alirezamp.news_domain.model.News
import ir.alirezamp.news_domain.model.PublisherNews
import ir.alirezamp.news_domain.reposiotry.NewsRepository

class NewsRepositoryImpl(
    private val newsService: NewsService,
) : NewsRepository {

    override suspend fun getHotNews(): DataState<List<News>> {
        val result = newsService.getHotNews()
        return result?.let {
            DataState.Success(result.map { it.mapToDomainModel() })
        } ?: DataState.Error(message = "unknown error")
    }

    override suspend fun getFavoriteNews(): DataState<List<News>> {
        val result = newsService.getFavoriteNews()
        return result?.let {
            DataState.Success(result.map { it.mapToDomainModel() })
        } ?: DataState.Error(message = "unknown error")
    }

    override suspend fun getEditorSuggestionNews(): DataState<List<News>> {
        val result = newsService.getEditorSuggestionNews()
        return result?.let {
            DataState.Success(result.map { it.mapToDomainModel() })
        } ?: DataState.Error(message = "unknown error")
    }

    override suspend fun getPublisherNews(): DataState<List<PublisherNews>> {
        val result = newsService.getPublisherNews()
        return result?.let {
            DataState.Success(result.map { it.mapToDomainModel() })
        } ?: DataState.Error(message = "unknown error")
    }

}