package ant.vit.publications.network

import ant.vit.publications.network.dto.PublicationsResponse
import io.reactivex.Single

/**
 * Created by Vitiello Antonio
 */
object RestRepository {
    private var networkProvider = NetworkProvider()

    fun getRestSingle(id: String): Single<PublicationsResponse> {
        return networkProvider.getPublicationsByIdSingle(id)
    }

}