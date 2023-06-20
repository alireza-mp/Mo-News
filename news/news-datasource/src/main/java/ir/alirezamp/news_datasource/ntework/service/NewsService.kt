package ir.alirezamp.news_datasource.ntework.service

import ir.alirezamp.news_datasource.ntework.dto.NewsDto

interface NewsService {

    suspend fun getHotNews(): List<NewsDto>?

    suspend fun getFavoriteNews(): List<NewsDto>?

    suspend fun getEditorSuggestionNews(): List<NewsDto>?

}