package com.northsoltech.network.models.signing


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TokenDTO(
    @SerialName("accessToken")
    var accessToken: String?
)