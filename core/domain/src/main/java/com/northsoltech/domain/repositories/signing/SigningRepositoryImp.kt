package com.northsoltech.domain.repositories.signing

import com.northsoltech.domain.remote.SigningDataSource
import javax.inject.Inject

class SigningRepositoryImp @Inject constructor(
 private val signingDataSource: SigningDataSource
):SigningRepository {
    override suspend fun signing(phoneNo: String, password: String) = signingDataSource.signing(phoneNo, password)
}