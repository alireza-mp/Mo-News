package ir.alirezamp.ui_news_detail.ui

import ir.alirezamp.designsystem.util.UniDirectionalViewModel
import ir.alirezamp.news_domain.model.NewsDetail

interface NewsDetailContract :
    UniDirectionalViewModel<NewsDetailContract.Event, NewsDetailContract.State> {

    data class State(
        val isFirstTimeAnimation: Boolean = false,
        val newsDetail: NewsDetail? = null,
    )

    sealed class Event {
        data class GetNewsDetail(val newsId: String) : Event()
        object DisableFirstTimeAnimation : Event()
    }

}