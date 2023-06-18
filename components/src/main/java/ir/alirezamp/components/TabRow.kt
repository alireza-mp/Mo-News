package ir.alirezamp.components


import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ir.alirezamp.components.util.TabState
import ir.alirezamp.designsystem.util.NoRippleInteractionSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow


@Composable
fun TabRow(
    modifier: Modifier = Modifier,
    tabState: TabState,
    onTabClick: (index: Int) -> Unit,
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(50.dp),
        backgroundColor = MaterialTheme.colorScheme.secondary,
        shape = MaterialTheme.shapes.medium,
    ) {
        BoxWithConstraints(
            modifier = Modifier
                .fillMaxSize()
                .padding(4.dp)
        ) {
            val inductorWidth = maxWidth / 2f
            val inductorXAnim by animateDpAsState(
                targetValue = if (tabState == TabState.Recommended) 0.dp else inductorWidth,
                animationSpec = tween(
                    durationMillis = 250,
                    easing = LinearEasing,
                )
            )
            val recommendedColor by animateColorAsState(
                targetValue = if (tabState == TabState.Recommended)
                    MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onSecondary,
                animationSpec = tween(
                    durationMillis = 250,
                    easing = LinearEasing,
                )
            )
            val flowingColor by animateColorAsState(
                targetValue = if (tabState == TabState.Flowing)
                    MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onSecondary,
                animationSpec = tween(
                    durationMillis = 250,
                    easing = LinearEasing,
                )
            )
            // inductor
            Card(
                modifier = Modifier
                    .width(inductorWidth)
                    .fillMaxHeight()
                    .offset(
                        x = inductorXAnim, // update inductor x offset
                        y = 0.dp,
                    ),
                backgroundColor = MaterialTheme.colorScheme.primary,
                shape = MaterialTheme.shapes.medium,
            ) {}
            // titles
            Row(
                modifier = Modifier.fillMaxSize(),
            ) {
                // recommended
                TextButton(
                    shape = MaterialTheme.shapes.medium,
                    modifier = Modifier
                        .weight(0.5f)
                        .fillMaxHeight(),
                    onClick = {
                        onTabClick(0)
                    },
                    interactionSource = NoRippleInteractionSource(),
                ) {
                    Text(
                        text = "پیشنهادی",
                        color = recommendedColor,
                        style = MaterialTheme.typography.titleLarge,
                    )
                }
                // flowing
                TextButton(
                    shape = MaterialTheme.shapes.medium,
                    modifier = Modifier
                        .weight(0.5f)
                        .fillMaxHeight(),
                    onClick = {
                        onTabClick(1)
                    },
                    interactionSource = NoRippleInteractionSource(),
                ) {
                    Text(
                        text = "دنبال میکنید",
                        color = flowingColor,
                        style = MaterialTheme.typography.titleLarge,
                    )
                }
            }
        }
    }
}
