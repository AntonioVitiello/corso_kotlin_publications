package ant.vit.publications.network

import ant.vit.publications.network.dto.PublicationsResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by Vitiello Antonio
 */
interface ApiService {

    //eg: https://run.mocky.io/v3/db048e88-3190-4449-af84-246fa9b68e60
    @GET("/v3/{id}")
    fun getPublicationsByIdSingle(@Path("id") id: String): Single<PublicationsResponse>

}