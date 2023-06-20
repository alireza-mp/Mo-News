package ir.alirezamp.news_list.ui.suggested_news

import androidx.lifecycle.viewModelScope
import ir.alirezamp.core.domain.DataState
import ir.alirezamp.designsystem.base.BaseContract
import ir.alirezamp.designsystem.base.BaseViewModel
import ir.alirezamp.news_domain.usecase.GetFavoriteNewsUseCase
import ir.alirezamp.news_domain.usecase.GetHotNewsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SuggestedNewsViewModel(
    private val getHotNews: GetHotNewsUseCase,
    private val getFavoriteNews: GetFavoriteNewsUseCase,
) : BaseViewModel(), SuggestedNewsContract {

    private val mutableState = MutableStateFlow(SuggestedNewsContract.State())
    override val state: StateFlow<SuggestedNewsContract.State> get() = mutableState.asStateFlow()

    init {
        getData()
    }

    private fun getData() {
        mutableBaseState.update {
            BaseContract.BaseState.OnLoading
        }
        viewModelScope.launch(Dispatchers.IO) {
            val hotNews = getHotNews()
            val favoriteNews = getFavoriteNews()
            when {
                hotNews is DataState.Success && favoriteNews is DataState.Success -> {
                    mutableState.update {
                        SuggestedNewsContract.State(
                            hotNews = hotNews.data ?: listOf(),
                            favoriteNews = favoriteNews.data ?: listOf(),
                        )
                    }
                    mutableBaseState.update {
                        BaseContract.BaseState.OnSuccess
                    }
                }

                hotNews is DataState.Error || favoriteNews is DataState.Error -> {
                    mutableBaseState.update {
                        BaseContract.BaseState.OnError(
                            message = hotNews.message ?: favoriteNews.message ?: "unknown"
                        )
                    }
                }
            }
        }
    }

    override fun event(event: SuggestedNewsContract.Event) = when (event) {
        else -> print("")
    }

    override fun onRetryPressed() {
        getData()
    }
}