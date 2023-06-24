package ir.alirezamp.ui_news_detail.ui

import androidx.lifecycle.viewModelScope
import ir.alirezamp.core.domain.DataState
import ir.alirezamp.designsystem.base.BaseContract
import ir.alirezamp.designsystem.base.BaseViewModel
import ir.alirezamp.news_domain.usecase.GetNewsDetailUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class NewsDetailViewModel(
    private val getNewsDetail: GetNewsDetailUseCase,
) : BaseViewModel(), NewsDetailContract {

    private val mutableState = MutableStateFlow(NewsDetailContract.State())
    override val state: StateFlow<NewsDetailContract.State> get() = mutableState.asStateFlow()
    private var newsId: String = "1"

    private fun getData(newsId: String) {
        this.newsId = newsId
        if (mutableState.value.newsDetail == null)
            viewModelScope.launch(Dispatchers.IO) {
                mutableBaseState.update {
                    BaseContract.BaseState.OnLoading
                }

                when (val result = getNewsDetail(newsId)) {
                    is DataState.Success -> {
                        mutableState.update {
                            NewsDetailContract.State(
                                isFirstTimeAnimation = true,
                                newsDetail = result.data,
                            )
                        }
                        mutableBaseState.update {
                            BaseContract.BaseState.OnSuccess
                        }
                    }

                    is DataState.Error -> mutableBaseState.update {
                        BaseContract.BaseState.OnError("unknown")
                    }
                }
            }
    }

    override fun event(event: NewsDetailContract.Event) = when (event) {
        is NewsDetailContract.Event.GetNewsDetail -> getData(event.newsId)
        is NewsDetailContract.Event.DisableFirstTimeAnimation -> mutableState.value =
            mutableState.value.copy(isFirstTimeAnimation = false)
    }

    override fun onRetryPressed() {
        getData(newsId)
    }
}