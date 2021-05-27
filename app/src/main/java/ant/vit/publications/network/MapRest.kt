package ant.vit.publications.model

import ant.vit.publications.network.dto.PublicationsResponse
import ant.vit.publications.tools.Utils.Companion.formatDateOrNull
import ant.vit.publications.tools.Utils.Companion.parseDateOrNull
import ant.vit.publications.tools.Utils.Companion.yearDateFormat

/**
 * Created by Vitiello Antonio
 */
fun mapRestResponse(response: PublicationsResponse): MutableList<PublicationModel> {
    return mutableListOf<PublicationModel>().apply {
        response.posts?.forEach { post ->
            add(PublicationModel().apply {
                id = post.id
                userId = post.userId
                title = post.title
                description = post.description
                imageUrl = post.image
                publishDate = parseDateOrNull(yearDateFormat, post.publishedAt)
                publishDateString = formatDateOrNull(yearDateFormat, publishDate)
            })
        }
    }
}

