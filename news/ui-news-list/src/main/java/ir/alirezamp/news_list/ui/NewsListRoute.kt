package ir.alirezamp.news_list.ui

import androidx.compose.runtime.Composable
import ir.alirezamp.designsystem.base.BaseViewModel

@Composable
fun NewsListRoute(
    //viewModel: NewsListViewModel = hiltViewModel(),
    onNavigateToNewsDetailScreen: (newsId: String) -> Unit,
    onProvideBaseViewModel: (baseViewModel: BaseViewModel) -> Unit,
) {

}