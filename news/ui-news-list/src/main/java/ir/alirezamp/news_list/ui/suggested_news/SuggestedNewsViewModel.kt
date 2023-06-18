package ir.alirezamp.news_list.ui.suggested_news

import ir.alirezamp.designsystem.base.BaseViewModel
import ir.alirezamp.news_domain.model.News
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class SuggestedNewsViewModel : BaseViewModel(), SuggestedNewsContract {

    private val mutableState = MutableStateFlow(SuggestedNewsContract.State())
    override val state: StateFlow<SuggestedNewsContract.State> get() = mutableState.asStateFlow()

    init {
        mutableState.value = mutableState.value.copy(hotNews = list, favoriteNews = list)
    }

    override fun event(event: SuggestedNewsContract.Event) = when (event) {
        else -> print("")
    }

}


private val list: List<News> = listOf(
    News(
        id = 1,
        newsId = 2,
        description = "jdsofiisdfji fdsifjsdoij fiojsd jfdsijf",
        category = "test",
        imageUrl = "jifsdoifsdi",
        publisher = "dhfo",
        publisherImageUrl = "jdso",
        recommended = "jjj",
        title = "11:33",
        time = "22"
    )
)