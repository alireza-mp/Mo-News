package ir.alirezamp.designsystem.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp

val Shapes = Shapes(
    small = RoundedCornerShape(4.dp),
    medium = RoundedCornerShape(22.dp),
    large = RoundedCornerShape(24.dp)
)

// bottom navigation selector card radius
val Shapes.bottomNavigationSelector: Shape
    @Composable
    get() = RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp)