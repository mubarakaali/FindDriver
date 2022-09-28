package com.northsoltech.network.datasource

import com.northsoltech.domain.models.ApiResource
import com.northsoltech.domain.models.signup.SignupRequest
import com.northsoltech.domain.models.signup.SignupResponse
import com.northsoltech.domain.remote.SignupRemoteDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SignupRemoteDataSourceTestImp @Inject constructor(
): BaseRemoteDataSource(),SignupRemoteDataSource {

    override fun signup(signupRequest: SignupRequest): Flow<ApiResource<SignupResponse>> {
     return flow {
         val data  = SignupResponse(message = "ha ali na fr dobara kiiia faryad",200)
         emit(ApiResource.Valid(data))
     }
    }

//    override fun signup(signupRequest: SignupRequest): Flow<ApiResource<SignupResponse>> = safeApiCall {
//        Log.d("jejeje ", "signupRequest: SignupDataSourceImp.... $signupRequest ")
////        apiServices.signup(SignupRequestDTO.fromDomain(signupRequest))
//        Response(SignupResponseDTO(dataDTO = null,"hali na fr ki rab sy faryaddd",200))
//
//    }.map { it->
//        it.transform {
//            Log.d("jejeje ", "signupRespone: SignupDataSourceImp.... $it ")
//            it.toDomain()
//        }
//    }
}