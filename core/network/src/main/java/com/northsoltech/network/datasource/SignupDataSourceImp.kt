package com.northsoltech.network.datasource

import android.util.Log
import com.northsoltech.domain.models.signup.SignupRequest
import com.northsoltech.domain.models.transform
import com.northsoltech.domain.remote.SignupDataSource
import com.northsoltech.network.NetworkApiServices
import com.northsoltech.network.models.signup.SignupRequestDTO
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class SignupDataSourceImp @Inject constructor(
    private val apiServices: NetworkApiServices

): BaseRemoteDataSource(),SignupDataSource {

    override fun signup(signupRequest: SignupRequest) = safeApiCall {
        Log.d("jejeje ", "signupRequest: SignupDataSourceImp.... $signupRequest ")
        apiServices.signup(SignupRequestDTO.fromDomain(signupRequest))
    }.map { it->
        it.transform {
            Log.d("jejeje ", "signupRespone: SignupDataSourceImp.... $it ")
            it.toDomain()
        }
    }
}