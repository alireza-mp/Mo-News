package ir.alirezamp.ui_discover_details.ui

import androidx.lifecycle.viewModelScope
import ir.alirezamp.core.domain.DataState
import ir.alirezamp.designsystem.base.BaseContract
import ir.alirezamp.designsystem.base.BaseViewModel
import ir.alirezamp.discover_domain.usecase.GetCategoriseUseCase
import ir.alirezamp.discover_domain.usecase.GetDiscoverDetailsUseCase
import ir.alirezamp.news_domain.usecase.GetEditorSuggestionNewsUseCase
import ir.alirezamp.publisher_domain.usecase.GetPublishersUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class DiscoverViewModel(
    private val getDiscoverDetailsUseCase: GetDiscoverDetailsUseCase,
    private val getPublishersUseCase: GetPublishersUseCase,
    private val getEditorSuggestionNewsUseCase: GetEditorSuggestionNewsUseCase,
    private val getCategoriseUseCase: GetCategoriseUseCase,
) : BaseViewModel(), DiscoverContract {

    private val mutableState = MutableStateFlow(DiscoverContract.State())
    override val state: StateFlow<DiscoverContract.State> get() = mutableState.asStateFlow()

    init {
        getData()
    }

    private fun getData() {
        if (state.value.news.isEmpty())
            viewModelScope.launch(Dispatchers.IO) {
                mutableBaseState.update {
                    BaseContract.BaseState.OnLoading
                }
                val discoverDetails = getDiscoverDetailsUseCase()
                val news = getEditorSuggestionNewsUseCase()
                val publishers = getPublishersUseCase()
                val categories = getCategoriseUseCase()
                when {
                    discoverDetails is DataState.Success && news is DataState.Success
                            && publishers is DataState.Success && categories is DataState.Success -> {
                        mutableBaseState.update {
                            BaseContract.BaseState.OnSuccess
                        }
                        mutableState.update {
                            DiscoverContract.State(
                                discoverDetail = discoverDetails.data,
                                publishers = publishers.data ?: emptyList(),
                                news = news.data ?: emptyList(),
                                categories = categories.data ?: emptyList(),
                            )
                        }
                    }

                    discoverDetails is DataState.Error || news is DataState.Error ||
                            publishers is DataState.Error || categories is DataState.Error ->
                        mutableBaseState.update {
                            BaseContract.BaseState.OnError(message = "unknown")
                        }
                }
            }
    }

    override fun event(event: DiscoverContract.Event) {

    }

    override fun onRetryPressed() {
        getData()
    }

}