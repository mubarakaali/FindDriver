package com.northsoltech.domain.repositories.signup

import com.northsoltech.domain.models.ApiResource
import com.northsoltech.domain.models.signup.SignupRequest
import com.northsoltech.domain.models.signup.SignupResponse
import com.northsoltech.domain.remote.SignupDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.*
import javax.inject.Inject
import kotlin.coroutines.coroutineContext

class SignupRepositoryImp @Inject constructor(
 private val signupDataSource: SignupDataSource
):SignupRepository {
    override suspend fun signup(signupRequest: SignupRequest):Flow<ApiResource<SignupResponse>>  = signupDataSource.signup(signupRequest)

}