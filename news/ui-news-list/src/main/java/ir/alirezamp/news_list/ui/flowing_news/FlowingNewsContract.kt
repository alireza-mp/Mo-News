package ir.alirezamp.news_list.ui.flowing_news

import ir.alirezamp.designsystem.util.UniDirectionalViewModel
import ir.alirezamp.news_domain.model.PublisherNews

interface FlowingNewsContract :
    UniDirectionalViewModel<FlowingNewsContract.Event, FlowingNewsContract.State> {

    data class State(
        val publisherNews: List<PublisherNews> = emptyList(),
    )

    sealed class Event {
        object GetPublisherNewsList : Event()
    }

}