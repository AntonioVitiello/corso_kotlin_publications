package ant.vit.publications.network.dto


import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Created by Vitiello Antonio
 */
data class Post(
    @JsonProperty("id")
    val id: Int?,
    @JsonProperty("user_id")
    val userId: Int?,
    @JsonProperty("title")
    val title: String?,
    @JsonProperty("description")
    val description: String?,
    @JsonProperty("image")
    val image: String?,
    @JsonProperty("published_at")
    val publishedAt: String?
)