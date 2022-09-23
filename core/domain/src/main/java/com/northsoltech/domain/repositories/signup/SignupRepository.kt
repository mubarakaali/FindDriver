package com.northsoltech.domain.repositories.signup

import com.northsoltech.domain.models.ApiResource
import com.northsoltech.domain.models.signup.SignupRequest
import com.northsoltech.domain.models.signup.SignupResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

interface SignupRepository {
     suspend fun signup(signupRequest: SignupRequest):Flow<ApiResource<SignupResponse>>
}