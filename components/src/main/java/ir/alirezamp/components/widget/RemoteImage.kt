package ir.alirezamp.components.widget

import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest

@Stable
@Composable
fun RemoteImage(
    modifier: Modifier = Modifier,
    imageUrl: String,
    crossFade: Boolean = true,
    contentScale: ContentScale = ContentScale.Crop,
    shapes: CornerBasedShape = RoundedCornerShape(0.dp),
) {
    AsyncImage(
        modifier = modifier
            .clip(shapes),
        model = ImageRequest.Builder(LocalContext.current)
            .data(imageUrl)
            .crossfade(crossFade)
            .build(),
        contentDescription = null,
        contentScale = contentScale,
    )
}