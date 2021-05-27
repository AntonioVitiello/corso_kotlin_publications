package ant.vit.publications.network.dto


import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Created by Vitiello Antonio
 */
data class PublicationsResponse(
    @JsonProperty("posts")
    val posts: List<Post>?
)