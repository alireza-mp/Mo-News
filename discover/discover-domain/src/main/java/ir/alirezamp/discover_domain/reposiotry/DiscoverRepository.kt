package ir.alirezamp.discover_domain.reposiotry

import ir.alirezamp.core.domain.DataState
import ir.alirezamp.discover_domain.model.Category
import ir.alirezamp.discover_domain.model.DiscoverDetail

interface DiscoverRepository {

    suspend fun getDiscoverDetails(): DataState<DiscoverDetail>

    suspend fun getCategories(): DataState<List<Category>>

}