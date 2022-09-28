package com.northsoltech.network.di

import com.northsoltech.domain.remote.SigningDataSource
import com.northsoltech.domain.remote.SignupRemoteDataSource
import com.northsoltech.network.ApiServices
import com.northsoltech.network.datasource.SigningDataSourceImp
import com.northsoltech.network.datasource.SignupRemoteDataSourceImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteApiModule {

    @Singleton
    @Provides
    fun providesRemoteSignup(apiServices: ApiServices ): SignupRemoteDataSource = SignupRemoteDataSourceImp(apiServices)

    @Provides
     fun providesRemoteSignings(apiServices: ApiServices): SigningDataSource = SigningDataSourceImp(apiServices)
}