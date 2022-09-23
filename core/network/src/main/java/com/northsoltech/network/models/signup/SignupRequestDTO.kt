package com.northsoltech.network.models.signup


import com.northsoltech.domain.models.signup.SignupRequest
import com.northsoltech.network.utils.TransformableRequest
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
//1 for rider
//2 for user
@Serializable
data class SignupRequestDTO(
    @SerialName("cnic")
    var cnic: String?,
    @SerialName("name")
    var name: String?,
    @SerialName("password")
    var password: String?,
    @SerialName("phone_no")
    var phoneNo: String?,
    @SerialName("user_type")
    var userType: String?
){
    companion object: TransformableRequest<SignupRequestDTO,SignupRequest> {
        override fun fromDomain(domainObj: SignupRequest)= SignupRequestDTO(
           cnic = domainObj.cnic,
            name = domainObj.name,
            password = domainObj.password,
            phoneNo = domainObj.phoneNo,
            userType = domainObj.userType
        )

    }
}