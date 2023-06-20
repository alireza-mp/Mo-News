package ir.alirezamp.components.util

import androidx.annotation.DrawableRes
import ir.alirezamp.components.R

enum class AppBarAction(@DrawableRes val iconId: Int) {
    SEARCH(iconId = R.drawable.ic_search),
    NOTIFICATION(iconId = R.drawable.notification_status),
    FILTTER(iconId = R.drawable.ic_filtter),
}
