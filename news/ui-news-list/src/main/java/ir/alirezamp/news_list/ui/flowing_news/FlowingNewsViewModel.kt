package ir.alirezamp.news_list.ui.flowing_news

import androidx.lifecycle.viewModelScope
import ir.alirezamp.core.domain.DataState
import ir.alirezamp.designsystem.base.BaseContract
import ir.alirezamp.designsystem.base.BaseViewModel
import ir.alirezamp.news_domain.usecase.GetPublisherNewsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class FlowingNewsViewModel(
    private val publisherNews: GetPublisherNewsUseCase,
) : BaseViewModel(), FlowingNewsContract {

    private val mutableState = MutableStateFlow(FlowingNewsContract.State())
    override val state: StateFlow<FlowingNewsContract.State> get() = mutableState.asStateFlow()

    private fun getData() {
        if (state.value.publisherNews.isEmpty())
            viewModelScope.launch(Dispatchers.IO) {
                when (val result = publisherNews()) {
                    is DataState.Success -> {
                        mutableState.update {
                            FlowingNewsContract.State(
                                publisherNews = result.data ?: emptyList()
                            )
                        }
                    }

                    is DataState.Error ->
                        mutableBaseState.update {
                            BaseContract.BaseState.OnError(result.message ?: "unknown")
                        }
                }
            }
    }

    override fun event(event: FlowingNewsContract.Event) = when (event) {
        is FlowingNewsContract.Event.getPbulisherNewsList -> getData()
    }

    override fun onRetryPressed() {
        getData()
    }

}