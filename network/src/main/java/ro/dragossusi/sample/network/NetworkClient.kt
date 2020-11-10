package ro.dragossusi.sample.network

import retrofit2.Response
import ro.dragossusi.resource.CompletionResource
import ro.dragossusi.resource.DataResource
import ro.rachieru.dragos.errordata.ErrorData
import ro.rachieru.dragos.errordata.StringErrorData


/**
 *
 * @since 9/16/20
 * @author dragos
 */
abstract class NetworkClient {

    /**
     * Transform response into data resource
     */
    suspend fun <T> dataCall(
        block: suspend () -> Response<T>
    ): DataResource<T> {
        return try {
            val response = block()
            if (response.isSuccessful) {
                DataResource.success(
                    response.body()
                )
            } else {
                when (response.code()) {
                    in 400..499 -> DataResource.error(
                        createError(response)
                    )
                    else -> DataResource.error(
                        ServerFailErrorData
                    )
                }
            }
        } catch (e: Exception) {
            DataResource.error(e)
        }
    }

    /**
     * Transform response into completion resource
     */
    suspend fun <T> completionCall(
        block: suspend () -> Response<T>
    ): CompletionResource {
        return try {
            val response = block()
            if (response.isSuccessful) {
                CompletionResource.completed()
            } else {
                when (response.code()) {
                    in 400..499 -> CompletionResource.error(
                        createError(response)
                    )
                    else -> CompletionResource.error(
                        ServerFailErrorData
                    )
                }
            }
        } catch (e: Exception) {
            CompletionResource.error(e)
        }
    }

    /**
     * add code for custom errors
     */
    private fun createError(response: Response<*>): ErrorData {
        return StringErrorData("Error")
    }

}