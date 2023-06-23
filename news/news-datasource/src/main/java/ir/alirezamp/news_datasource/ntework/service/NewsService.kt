package ir.alirezamp.news_datasource.ntework.service

import ir.alirezamp.news_datasource.ntework.dto.NewsDetailDto
import ir.alirezamp.news_datasource.ntework.dto.NewsDto
import ir.alirezamp.news_datasource.ntework.dto.PublisherNewsDto

interface NewsService {

    suspend fun getHotNews(): List<NewsDto>?

    suspend fun getFavoriteNews(): List<NewsDto>?

    suspend fun getEditorSuggestionNews(): List<NewsDto>?
    suspend fun getPublisherNews(): List<PublisherNewsDto>?

    suspend fun getNewsDetail(newsId: String): NewsDetailDto?
}