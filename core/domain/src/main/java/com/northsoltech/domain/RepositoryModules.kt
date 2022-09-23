package com.northsoltech.domain

import com.northsoltech.domain.repositories.signup.SignupRepository
import com.northsoltech.domain.repositories.signup.SignupRepositoryImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityScoped

@Module
@InstallIn(ActivityRetainedComponent::class)
abstract class RepositoryModules {
    @ActivityScoped
    @Binds
    abstract fun bindsSignupRepository(signupRepositoryImp: SignupRepositoryImp):SignupRepository
}