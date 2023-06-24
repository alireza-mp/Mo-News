package ir.alirezamp.news_datasource.ntework.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NewsDto(
    @SerialName("category")
    val category: String,
    @SerialName("category_id")
    val categoryId: String,
    @SerialName("description")
    val description: String,
    @SerialName("id")
    val id: Int,
    @SerialName("image_url")
    val imageUrl: String,
    @SerialName("publisher")
    val publisher: String,
    @SerialName("publisher_image_url")
    val publisherImageUrl: String,
    @SerialName("recommended")
    val recommended: String,
    @SerialName("time")
    val time: Int,
    @SerialName("title")
    val title: String,
)