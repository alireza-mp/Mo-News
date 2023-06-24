package ir.alirezamp.components.util

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

fun Modifier.alphaAnimation(enabled: Boolean = true, delay: Int, duration: Int) = composed {
    if (enabled) {
        val anim = remember { Animatable(initialValue = 0f) }

        LaunchedEffect(anim) {
            anim.animateTo(
                targetValue = 1f,
                animationSpec = tween(
                    durationMillis = duration,
                    delayMillis = delay,
                )
            )
        }

        this.alpha(anim.value)
    } else this
}

fun Modifier.offsetYAnimation(
    enabled: Boolean,
    delay: Int,
    duration: Int,
    startOffset: Dp,
    endOffset: Dp,
) =
    composed {
        if (enabled) {
            val animY = remember { Animatable(initialValue = startOffset.value) }
            LaunchedEffect(animY) {
                animY.animateTo(
                    targetValue = endOffset.value,
                    animationSpec = tween(
                        durationMillis = duration,
                        delayMillis = delay,
                    )
                )
            }
            this.offset(x = 0.dp, y = animY.value.dp)
        } else this
    }