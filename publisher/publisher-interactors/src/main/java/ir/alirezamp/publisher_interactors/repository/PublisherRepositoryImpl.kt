package ir.alirezamp.publisher_interactors.repository

import ir.alirezamp.core.domain.DataState
import ir.alirezamp.publisher_datasource.network.mappers.mapToDomainModel
import ir.alirezamp.publisher_datasource.network.service.PublisherDatasource
import ir.alirezamp.publisher_domain.model.Publisher
import ir.alirezamp.publisher_domain.reposiotry.PublisherRepository

class PublisherRepositoryImpl(
    private val publisherDatasource: PublisherDatasource,
) : PublisherRepository {

    override suspend fun getPublishers(): DataState<List<Publisher>> {
        val response = publisherDatasource.getPublishers()
        return response?.let {
            DataState.Success(response.map { it.mapToDomainModel() })
        } ?: DataState.Error(message = "unknown error")
    }

}