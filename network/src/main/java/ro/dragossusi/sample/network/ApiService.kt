package ro.dragossusi.sample.network

import retrofit2.Response
import retrofit2.http.GET
import ro.dragossusi.sample.data.Issue

/**
 * Example retrofit implementation
 *
 * @author dragos
 * @since 11/10/20
 */
interface ApiService {

    @GET("issues")
    suspend fun getIssues(): Response<List<Issue>>


}