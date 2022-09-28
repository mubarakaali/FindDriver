package com.northsoltech.domain.repositories.signup

import com.northsoltech.domain.models.ApiResource
import com.northsoltech.domain.models.signup.SignupRequest
import com.northsoltech.domain.models.signup.SignupResponse
import com.northsoltech.domain.remote.SigningDataSource
import com.northsoltech.domain.remote.SignupRemoteDataSource
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class SignupRepositoryImp @Inject constructor(
 private val signupDataSource: SignupRemoteDataSource
):SignupRepository {
    override suspend fun signup(signupRequest: SignupRequest):Flow<ApiResource<SignupResponse>>  = signupDataSource.signup(signupRequest)

}