package ir.alirezamp.discover_datasource.network.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DiscoverDetailDto(
    @SerialName("banners")
    val banners: List<String>,
    @SerialName("subtitle")
    val subtitle: String,
)