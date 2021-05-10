package ro.dragossusi.sample.network

import retrofit2.Response
import ro.dragossusi.messagedata.MessageData
import ro.dragossusi.messagedata.error.toThrowable
import ro.dragossusi.messagedata.toMessageData
import ro.dragossusi.resource.CompletionResource


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
    ): T {
        val response = block()
        return if (response.isSuccessful) {
            response.body() as T
        } else {
            when (response.code()) {
                in 400..499 -> throw createError(response).toThrowable()
                else -> throw ServerFailErrorData.toThrowable()
            }
        }
    }

    /**
     * Transform response into completion resource
     */
    suspend fun <T> completionCall(
        block: suspend () -> Response<T>
    ) {
        val response = block()
        if (response.isSuccessful) {
            CompletionResource.completed()
        } else {
            when (response.code()) {
                in 400..499 -> throw createError(response).toThrowable()
                else -> throw ServerFailErrorData.toThrowable()
            }
        }
    }

    /**
     * add code for custom errors
     */
    private fun createError(response: Response<*>): MessageData {
        return "Error".toMessageData()
    }

}