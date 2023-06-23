package ir.alirezamp.publisher_domain.model

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

@Immutable
data class Publisher(
    val categoryId: Int,
    val id: Int,
    val imageUrl: String,
    val title: String,
    val flowing: MutableState<Boolean> = mutableStateOf(false),
)