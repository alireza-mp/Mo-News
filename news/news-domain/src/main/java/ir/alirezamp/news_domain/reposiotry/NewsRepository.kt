package ir.alirezamp.news_domain.reposiotry

import ir.alirezamp.core.domain.DataState
import ir.alirezamp.news_domain.model.News
import ir.alirezamp.news_domain.model.PublisherNews

interface NewsRepository {

    suspend fun getHotNews(): DataState<List<News>>

    suspend fun getFavoriteNews(): DataState<List<News>>

    suspend fun getEditorSuggestionNews(): DataState<List<News>>

    suspend fun getPublisherNews(): DataState<List<PublisherNews>>

}