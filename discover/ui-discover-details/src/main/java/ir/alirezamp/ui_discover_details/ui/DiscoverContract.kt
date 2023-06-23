package ir.alirezamp.ui_discover_details.ui

import androidx.compose.runtime.Immutable
import ir.alirezamp.designsystem.util.UniDirectionalViewModel
import ir.alirezamp.discover_domain.model.Category
import ir.alirezamp.discover_domain.model.DiscoverDetail
import ir.alirezamp.discover_domain.model.allCategory
import ir.alirezamp.news_domain.model.News
import ir.alirezamp.publisher_domain.model.Publisher

interface DiscoverContract :
    UniDirectionalViewModel<DiscoverContract.Event, DiscoverContract.State> {


    @Immutable
    data class State(
        val discoverDetail: DiscoverDetail? = null,
        var publishers: List<Publisher> = listOf(),
        val news: List<News> = emptyList(),
        val categories: List<Category> = emptyList(),
        val selectedCategoryId: Int = allCategory.id,
        val count: Int = 0,
    )

    sealed class Event {
        class OnCategoryClick(val id: Int) : Event()
        class ChangePublisherFlowing(val id: Int, val state: Boolean) : Event()

        object UpdateCount : Event()
    }

}