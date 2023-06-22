package ir.alirezamp.publisher_datasource.network.service

import ir.alirezamp.publisher_datasource.network.dto.PublisherDto

interface PublisherDatasource {

    suspend fun getPublishers(): List<PublisherDto>?

}