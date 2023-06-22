package ir.alirezamp.ui_discover_details.components

import androidx.compose.animation.core.CubicBezierEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow

@Composable
fun AutoScrollingText(
    text: String,
    color: Color,
    style: TextStyle,
) {
    val scrollState = rememberScrollState()

    var shouldAnimate by remember {
        mutableStateOf(true)
    }
    val duration = text.length * 86
    LaunchedEffect(shouldAnimate) {
        scrollState.animateScrollTo(
            scrollState.maxValue,
            animationSpec = tween(
                durationMillis = duration,
                delayMillis = 0,
                easing = CubicBezierEasing(0f, 0f, 0f, 0f)
            )
        )
        scrollState.scrollTo(0)
        shouldAnimate = !shouldAnimate
    }
    Text(
        modifier = Modifier
            .horizontalScroll(scrollState, false)
            .fillMaxWidth(),
        text = text,
        color = color,
        style = style,
        overflow = TextOverflow.Ellipsis,
        maxLines = 1,
    )
}