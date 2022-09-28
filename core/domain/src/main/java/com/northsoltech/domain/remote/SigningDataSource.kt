package com.northsoltech.domain.remote

import com.northsoltech.domain.models.ApiResource
import com.northsoltech.domain.models.loging.LoginData
import kotlinx.coroutines.flow.Flow

interface SigningDataSource {
    fun signing(phoneNo:String,password:String): Flow<ApiResource<LoginData>>
}