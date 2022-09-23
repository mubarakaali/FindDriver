package com.northsoltech.network.datasource

import com.northsoltech.domain.models.ApiResource
import com.northsoltech.network.utils.NetworkUtils.getErrorMessage
import com.northsoltech.network.utils.NetworkUtils.getNetworkErrorMessage
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response

abstract class BaseRemoteDataSource {

    /**
     * This method  will safely invoke the remote api call and return a flow of [Resource]s
     */
      fun <T : Any> safeApiCall( // TODO: Move this to a retrofit adapter
        call: suspend () -> Response<T>
    ): Flow<ApiResource<T>> =
        flow {
            emit(ApiResource.Loading())
            try {
                emit(safeApiResult(call.invoke()))
            } catch (e: Exception) {
                emit(ApiResource.Invalid<T>(message = getNetworkErrorMessage(e)))
            }
        }


    private  fun <T> safeApiResult(response: Response<T>): ApiResource<T> =
        if (response.isSuccessful) ApiResource.Valid(response.body()!!)
        else ApiResource.Invalid(message = getErrorMessage(response.code()))

}