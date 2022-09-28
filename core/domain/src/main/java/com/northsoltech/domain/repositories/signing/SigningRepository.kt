package com.northsoltech.domain.repositories.signing

import com.northsoltech.domain.models.ApiResource
import com.northsoltech.domain.models.loging.LoginData
import com.northsoltech.domain.models.signup.SignupRequest
import com.northsoltech.domain.models.signup.SignupResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

interface SigningRepository {
     suspend fun signing(phoneNo:String,password:String):Flow<ApiResource<LoginData>>
}