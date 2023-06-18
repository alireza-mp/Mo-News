package ir.alirezamp.navigation

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import ir.alirezamp.designsystem.theme.bottomNavigationSelector


@Composable
fun BottomNavigation(
    currentRoute: String,
    onItemClick: (route: String) -> Unit,
) {
    BoxWithConstraints {
        val numberOfTabs = 5
        val selectorWidth = 50
        val selectorHeight = 10
        val spaceBetweenTabs = (maxWidth / numberOfTabs.dp)
        val firstPoint = ((spaceBetweenTabs - selectorWidth) / 2)
        val tabsPoint = mutableListOf<Float>()
        for (tabNumber in 0 until numberOfTabs) {
            tabsPoint.add(firstPoint + (spaceBetweenTabs * tabNumber))
        }
        val items = listOf(
            BottomNavigationTabs.Home,
            BottomNavigationTabs.Discover,
            BottomNavigationTabs.AddNew,
            BottomNavigationTabs.Save,
            BottomNavigationTabs.Profile,
        )
        val enabledRoute = currentRoute.findDestinations()?.enabledBottomNavigationRoute ?: ""
        Content(
            currentRoute = currentRoute,
            tabsPoint = tabsPoint,
            items = items,
            selectorHeight = selectorHeight,
            selectorWidth = selectorWidth,
            enabledIndex = items.indexOf(items.find { it.screenRoute == enabledRoute } ?: 0),
            onBottomItemClick = { onItemClick(it) }
        )
    }
}


@Composable
private fun Content(
    currentRoute: String,
    tabsPoint: List<Float>,
    items: List<BottomNavigationTabs>,
    selectorHeight: Int,
    selectorWidth: Int,
    enabledIndex: Int,
    onBottomItemClick: (route: String) -> Unit,
) {

    val selectorXPointState = remember { mutableStateOf(tabsPoint[0].dp) }

    BottomNavigation(
        modifier = Modifier.fillMaxWidth(),
        backgroundColor = MaterialTheme.colorScheme.surfaceVariant
    ) {
        items.forEachIndexed { index, item ->
            BottomNavigationItem(
                icon = {
                    if (index == enabledIndex) {
                        Image(
                            painterResource(id = item.enabledIcon),
                            contentDescription = null
                        )
                    } else {
                        Icon(
                            painterResource(id = item.icon),
                            contentDescription = null
                        )
                    }
                },
                selectedContentColor = MaterialTheme.colorScheme.primary,
                unselectedContentColor = MaterialTheme.colorScheme.onSurfaceVariant,
                selected = currentRoute == item.screenRoute,
                onClick = {
                    selectorXPointState.value = tabsPoint[index].dp
                    onBottomItemClick(items[index].screenRoute)
                }
            )
        }
    }

    SelectorUI(
        selectorWidth = selectorWidth,
        selectorHeight = selectorHeight,
        selectorXPointState = selectorXPointState.value,
    )

}

@Composable
private fun SelectorUI(
    selectorWidth: Int,
    selectorHeight: Int,
    selectorXPointState: Dp,
) {

    val selectorXAnim by animateDpAsState(
        targetValue = selectorXPointState,
        animationSpec = tween(
            durationMillis = 200,
            easing = LinearEasing
        )
    )
    // selector
    Card(
        modifier = Modifier
            .size(width = selectorWidth.dp, height = selectorHeight.dp)
            .offset(x = selectorXAnim)
            .coloredShadow(
                color = MaterialTheme.colorScheme.primary,
                alpha = 0.6f,
                borderRadius = 0.dp,
                shadowRadius = 20.dp,
                offsetY = 10.dp,
                offsetX = 0.dp,
            ),
        shape = MaterialTheme.shapes.bottomNavigationSelector,
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primary),
    ) {}
}

// colored shadow
private fun Modifier.coloredShadow(
    color: Color,
    alpha: Float = 0.2f,
    borderRadius: Dp = 0.dp,
    shadowRadius: Dp = 20.dp,
    offsetY: Dp = 0.dp,
    offsetX: Dp = 0.dp,
) = this.drawBehind {

    val shadowColor = color.copy(alpha = alpha).toArgb()
    val transparent = color.copy(alpha = 0f).toArgb()

    this.drawIntoCanvas {
        val paint = Paint()
        val frameworkPaint = paint.asFrameworkPaint()
        frameworkPaint.color = transparent

        frameworkPaint.setShadowLayer(
            shadowRadius.toPx(),
            offsetX.toPx(),
            offsetY.toPx(),
            shadowColor
        )
        it.drawRoundRect(
            left = 10f,
            top = 0f,
            right = this.size.width - 10,
            bottom = this.size.height,
            radiusX = borderRadius.toPx(),
            radiusY = borderRadius.toPx(),
            paint = paint

        )
    }
}