package com.northsoltech.domain.models.signup


//1 for rider
//2 for user
data class SignupRequest(
    var cnic: String?,
    var name: String?,
    var password: String?,
    var phoneNo: String?,
    var userType: String?
)