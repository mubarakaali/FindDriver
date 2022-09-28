package com.northsoltech.network.models.signing


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Data(
    @SerialName("token")
    var tokenDTO: TokenDTO?,
    @SerialName("user")
    var user: UserDTO?
)