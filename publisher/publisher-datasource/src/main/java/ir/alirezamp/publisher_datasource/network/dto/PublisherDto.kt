package ir.alirezamp.publisher_datasource.network.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PublisherDto(
    @SerialName("category_id")
    val categoryId: Int,
    @SerialName("id")
    val id: Int,
    @SerialName("image_url")
    val imageUrl: String,
    @SerialName("title")
    val title: String,
)