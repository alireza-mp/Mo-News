package ir.alirezamp.discover_datasource.network.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CategoryDto(
    @SerialName("id")
    val id: Int,
    @SerialName("title")
    val title: String,
)