package ir.alirezamp.components.util

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Immutable
import ir.alirezamp.components.R

@Immutable
enum class AppBarAction(@DrawableRes val iconId: Int) {
    SEARCH(iconId = R.drawable.ic_search),
    NOTIFICATION(iconId = R.drawable.notification_status),
    FILTER(iconId = R.drawable.ic_filtter),
}
