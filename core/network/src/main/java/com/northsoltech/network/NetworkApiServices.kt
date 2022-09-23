package com.northsoltech.network

import com.northsoltech.network.utils.ApiConstants.SIGNUP
import com.northsoltech.network.models.signup.SignupRequestDTO
import com.northsoltech.network.models.signup.SignupResponseDTO
import retrofit2.Response
import retrofit2.http.POST

interface NetworkApiServices {

    @POST(SIGNUP)
    fun signup(signupRequestDTO: SignupRequestDTO):Response<SignupResponseDTO>
}