package ir.alirezamp.discover_interactors.repository

import ir.alirezamp.core.domain.DataState
import ir.alirezamp.discover_datasource.network.mapper.mapToDomainModel
import ir.alirezamp.discover_datasource.network.service.DiscoverDatasource
import ir.alirezamp.discover_domain.model.Category
import ir.alirezamp.discover_domain.model.DiscoverDetail
import ir.alirezamp.discover_domain.reposiotry.DiscoverRepository

class DiscoverRepositoryImpl(
    private val discoverDatasource: DiscoverDatasource,
) : DiscoverRepository {

    override suspend fun getDiscoverDetails(): DataState<DiscoverDetail> {
        val response = discoverDatasource.getDiscoverDetails()
        return response?.let {
            DataState.Success(response.mapToDomainModel())
        } ?: DataState.Error(message = "unknown error")
    }

    override suspend fun getCategories(): DataState<List<Category>> {
        val response = discoverDatasource.getCategories()
        return response?.let {
            DataState.Success(response.map { it.mapToDomainModel() })
        } ?: DataState.Error(message = "unknown error")
    }
}