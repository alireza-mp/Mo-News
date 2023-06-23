package ir.alirezamp.discover_domain.model

import androidx.compose.runtime.Immutable

@Immutable
data class Category(
    val id: Int,
    val title: String,
)

val allCategory = Category(
    id = 0,
    title = "همه",
)