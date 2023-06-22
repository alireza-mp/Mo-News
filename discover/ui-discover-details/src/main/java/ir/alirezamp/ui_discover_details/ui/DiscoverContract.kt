package ir.alirezamp.ui_discover_details.ui

import ir.alirezamp.designsystem.util.UniDirectionalViewModel
import ir.alirezamp.discover_domain.model.Category
import ir.alirezamp.discover_domain.model.DiscoverDetail
import ir.alirezamp.news_domain.model.News
import ir.alirezamp.publisher_domain.model.Publisher

interface DiscoverContract :
    UniDirectionalViewModel<DiscoverContract.Event, DiscoverContract.State> {


    data class State(
        val discoverDetail: DiscoverDetail? = null,
        val publishers: List<Publisher> = emptyList(),
        val news: List<News> = emptyList(),
        val categories: List<Category> = emptyList(),
    )

    sealed class Event

}