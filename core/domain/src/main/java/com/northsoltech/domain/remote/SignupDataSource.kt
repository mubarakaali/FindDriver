package com.northsoltech.domain.remote

import com.northsoltech.domain.models.ApiResource
import com.northsoltech.domain.models.signup.SignupRequest
import com.northsoltech.domain.models.signup.SignupResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

interface SignupDataSource {
    fun signup(signupRequest: SignupRequest): Flow<ApiResource<SignupResponse>>
}