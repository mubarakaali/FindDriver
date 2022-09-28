package com.northsoltech.domain

import com.northsoltech.domain.repositories.signing.SigningRepository
import com.northsoltech.domain.repositories.signing.SigningRepositoryImp
import com.northsoltech.domain.repositories.signup.SignupRepository
import com.northsoltech.domain.repositories.signup.SignupRepositoryImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped

@Module
@InstallIn(ActivityRetainedComponent::class)
interface RepositoryModules {

    @Binds
    @ActivityRetainedScoped
    fun bindsSignupRepositorys(signupRepositoryImp: SignupRepositoryImp): SignupRepository

     @Binds
     @ActivityRetainedScoped
     fun providesSigningRepositorys(signingRepositoryImp: SigningRepositoryImp): SigningRepository
}