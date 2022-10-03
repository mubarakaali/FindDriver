package com.northsoltech.domain.models.signup


//1 for rider
//2 for user
data class SignupRequest(
    var name: String,
    var phoneNo: String,
    var cnic: String,
    var password: String,
    var userType: String
){

    fun validateData():Boolean{
        return !(name.isEmpty()||phoneNo.isEmpty()||cnic.isEmpty()||password.isEmpty()||userType.isEmpty())
    }
}