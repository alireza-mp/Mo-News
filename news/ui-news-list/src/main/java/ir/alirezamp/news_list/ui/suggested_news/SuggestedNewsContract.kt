package ir.alirezamp.news_list.ui.suggested_news

import ir.alirezamp.designsystem.util.UniDirectionalViewModel
import ir.alirezamp.news_domain.model.News

interface SuggestedNewsContract :
    UniDirectionalViewModel<SuggestedNewsContract.Event, SuggestedNewsContract.State> {


    data class State(
        val isFirstTimeAnimation: Boolean = false,
        val hotNews: List<News> = listOf(),
        val favoriteNews: List<News> = listOf(),
    )

    sealed class Event {
        object DisableFirstTimeAnimation : Event()
    }


}