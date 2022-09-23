package com.northsoltech.network.di

import com.northsoltech.domain.remote.SignupDataSource
import com.northsoltech.network.datasource.SignupDataSourceImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityScoped

@Module
@InstallIn(ActivityRetainedComponent::class)
interface DataSourceModule {
    @ActivityScoped
    @Binds
    fun bindsSignupDataSource(signupDataSourceImp: SignupDataSourceImp):SignupDataSource
}