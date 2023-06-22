package ir.alirezamp.publisher_domain.reposiotry

import ir.alirezamp.core.domain.DataState
import ir.alirezamp.publisher_domain.model.Publisher

interface PublisherRepository {

    suspend fun getPublishers(): DataState<List<Publisher>>

}