package com.northsoltech.network.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.northsoltech.network.utils.ApiConstants.BASE_URL
import com.northsoltech.network.BuildConfig
import com.northsoltech.network.NetworkApiServices
import com.northsoltech.network.NetworkCacheInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.create
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
   fun providesJson(): Json = Json {
       ignoreUnknownKeys = true
    }

    @Provides
    @Singleton
    fun providesRetrofit(
        networkJson: Json,
        okHttpClient: OkHttpClient
    ):NetworkApiServices{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(networkJson.asConverterFactory("application/json".toMediaType()))
            .client(okHttpClient)
            .build()
            .create()
    }

    @Provides
    @Singleton
    fun provideLoggingInterceptor() =
        HttpLoggingInterceptor().setLevel(if (BuildConfig.DEBUG)
            HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE)

    @Provides
    @Singleton
    fun provideOkHttp(
        interceptor: HttpLoggingInterceptor,
        networkCacheInterceptor: NetworkCacheInterceptor,
    ) =
        OkHttpClient.Builder()
            .connectTimeout(15L, TimeUnit.SECONDS)
            .writeTimeout(15L, TimeUnit.SECONDS)
            .readTimeout(15L, TimeUnit.SECONDS)
            .addNetworkInterceptor(networkCacheInterceptor)
            .addInterceptor(interceptor)
            .build()

    @Provides
    fun provideNetworkCacheInterceptor() = NetworkCacheInterceptor(7, TimeUnit.DAYS)
}