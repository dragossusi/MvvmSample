package ro.dragossusi.sample.network

import javax.inject.Inject

/**
 *
 * @author dragos
 * @since 11/10/20
 */
class ApiClient @Inject constructor(
    private val apiService: ApiService,
) : NetworkClient() {

    suspend fun getIssues() = dataCall {
        apiService.getIssues()
    }

}