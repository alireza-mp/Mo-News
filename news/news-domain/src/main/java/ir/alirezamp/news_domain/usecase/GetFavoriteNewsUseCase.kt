package ir.alirezamp.news_domain.usecase

import ir.alirezamp.news_domain.reposiotry.NewsRepository

class GetFavoriteNewsUseCase(
    private val newsRepository: NewsRepository,
) {

    suspend operator fun invoke() = newsRepository.getFavoriteNews()

}