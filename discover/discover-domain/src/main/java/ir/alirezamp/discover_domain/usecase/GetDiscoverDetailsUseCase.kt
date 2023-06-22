package ir.alirezamp.discover_domain.usecase

import ir.alirezamp.discover_domain.reposiotry.DiscoverRepository

class GetDiscoverDetailsUseCase(
    private val discoverRepository: DiscoverRepository,
) {

    suspend operator fun invoke() = discoverRepository.getDiscoverDetails()

}