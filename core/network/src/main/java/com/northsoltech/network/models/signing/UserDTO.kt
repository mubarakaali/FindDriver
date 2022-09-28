package com.northsoltech.network.models.signing


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserDTO(
    @SerialName("id")
    var id: Int?,
    @SerialName("name")
    var name: String?,
    @SerialName("phone_no")
    var phoneNo: String?,
    @SerialName("user_type")
    var userType: String?
)