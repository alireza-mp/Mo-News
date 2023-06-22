package ir.alirezamp.publisher_domain.usecase

import ir.alirezamp.publisher_domain.reposiotry.PublisherRepository

class GetPublishersUseCase(
    private val publisherRepository: PublisherRepository,
) {

    suspend operator fun invoke() = publisherRepository.getPublishers()

}