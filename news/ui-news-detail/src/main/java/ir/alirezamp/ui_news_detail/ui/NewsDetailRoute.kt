package ir.alirezamp.ui_news_detail.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import ir.alirezamp.designsystem.base.BaseViewModel

@Composable
fun NewsDetailRoute(
    newsId: String,
    onProvideBaseViewModel: (baseViewModel: BaseViewModel) -> Unit,
) {

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("news id is : $newsId", color = Color.Black)
    }

}


