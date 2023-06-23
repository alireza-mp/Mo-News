package ir.alirezamp.news_domain.usecase

import ir.alirezamp.news_domain.reposiotry.NewsRepository

class GetNewsDetailUseCase(
    private val newsRepository: NewsRepository,
) {

    suspend operator fun invoke(newsId: String) = newsRepository.getNewsDetail(newsId)

}