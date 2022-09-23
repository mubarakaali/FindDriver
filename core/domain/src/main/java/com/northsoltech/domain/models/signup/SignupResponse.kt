package com.northsoltech.domain.models.signup


data class SignupResponse(
    var `data`: Data?,
    var message: String?,
    var statusCode: Int?
)