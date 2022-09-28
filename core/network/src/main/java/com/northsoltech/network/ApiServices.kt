package com.northsoltech.network

import com.northsoltech.network.models.signing.LoginResponse
import com.northsoltech.network.models.signup.SignupRequestDTO
import com.northsoltech.network.models.signup.SignupResponseDTO
import com.northsoltech.network.utils.ApiConstants.SIGNIN
import com.northsoltech.network.utils.ApiConstants.SIGNUP
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiServices {

    @POST(SIGNUP)
   suspend fun signup(@Body signupRequestDTO: SignupRequestDTO):Response<SignupResponseDTO>

    @POST(SIGNIN)
    suspend fun signing(@Query("phone_no") phoneNo:String, @Query("password") password:String):Response<LoginResponse>

}