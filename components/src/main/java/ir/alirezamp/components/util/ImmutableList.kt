package ir.alirezamp.components.util

import androidx.compose.runtime.Immutable

@Immutable
data class ImmutableList<T>(
    val items: List<T>,
)