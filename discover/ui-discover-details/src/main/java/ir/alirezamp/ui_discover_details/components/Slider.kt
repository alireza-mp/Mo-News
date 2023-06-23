@file:OptIn(ExperimentalFoundationApi::class)

package ir.alirezamp.ui_discover_details.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.Stable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import ir.alirezamp.components.util.ImmutableList
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@Stable
@Composable
fun Slider(
    padding: PaddingValues = PaddingValues(),
    imagesUrls: ImmutableList<String>,
) {
    val pagerState = rememberPagerState()
    val coroutineScope = rememberCoroutineScope()
    Box(modifier = Modifier.fillMaxSize()) {

        HorizontalPager(
            pageCount = imagesUrls.items.size,
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp),
            state = pagerState,
        ) { page ->
            AsyncImage(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .clip(MaterialTheme.shapes.medium),
                model = ImageRequest.Builder(LocalContext.current)
                    .data(imagesUrls.items[page])
                    .crossfade(true)
                    .build(),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
            )
        }

        PagerIndicator(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 16.dp),
            itemCount = imagesUrls.items.size,
            activeColor = MaterialTheme.colorScheme.primary,
            inActiveColor = MaterialTheme.colorScheme.onSecondary,
            pagerState = pagerState,
            onClick = {
                coroutineScope.launch {
                    pagerState.animateScrollToPage(it)
                }
            }
        )

    }

    LaunchedEffect(Unit) {
        var page: Int
        while (true) {
            delay(3000)
            page = if (pagerState.currentPage == imagesUrls.items.size - 1)
                0 else pagerState.currentPage + 1
            pagerState.animateScrollToPage(page)
        }
    }

}

