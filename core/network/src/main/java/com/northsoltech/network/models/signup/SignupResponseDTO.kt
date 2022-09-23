package com.northsoltech.network.models.signup


import com.northsoltech.domain.models.signup.SignupResponse
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SignupResponseDTO(
    @SerialName("data")
    var dataDTO: DataDTO?,
    @SerialName("message")
    var message: String?,
    @SerialName("statusCode")
    var statusCode: Int?,
) {

    fun toDomain() = SignupResponse(
        data = null,
        message = message,
        statusCode = statusCode
    )
}