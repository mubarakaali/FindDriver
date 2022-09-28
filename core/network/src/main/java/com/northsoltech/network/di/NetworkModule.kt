package com.northsoltech.network.di

import android.content.Context
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.northsoltech.network.utils.ApiConstants.BASE_URL
import com.northsoltech.network.BuildConfig
import com.northsoltech.network.ApiServices
import com.northsoltech.network.NetworkCacheInterceptor
import com.northsoltech.network.utils.NetWorkConnectionInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import java.lang.Exception
import java.lang.RuntimeException
import java.security.SecureRandom
import java.security.cert.CertificateException
import java.security.cert.X509Certificate
import java.util.concurrent.TimeUnit
import javax.inject.Singleton
import javax.net.ssl.SSLContext
import javax.net.ssl.SSLSocketFactory
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule{

    @Provides
    fun providesJson(): Json {
        val module = SerializersModule {

        }
        return Json {
            isLenient = true
            ignoreUnknownKeys = true
            serializersModule = module
        }
    }

    @OptIn(ExperimentalSerializationApi::class)
    @Provides
    @Singleton
    fun providesRetrofit(
        json: Json,
        okHttpClient: OkHttpClient
    ):Retrofit {
       val  contentType = "application/json".toMediaType()
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(json.asConverterFactory(contentType))
            .build()
    }

//    @Singleton
//    @Provides
//    fun getUnsafeOkHttpClient(): OkHttpClient.Builder {
//        return try {
//            // Create a trust manager that does not validate certificate chains
//            val trustAllCerts: Array<TrustManager> = arrayOf(
//                object : X509TrustManager {
//                    @Throws(CertificateException::class)
//                    override fun checkClientTrusted(chain: Array<X509Certificate?>?, authType: String?) {
//                    }
//
//                    @Throws(CertificateException::class)
//                    override fun checkServerTrusted(chain: Array<X509Certificate?>?, authType: String?) {
//                    }
//
//                    override fun getAcceptedIssuers(): Array<X509Certificate> {
//                        return arrayOf()
//                    }
//                }
//            )
//
//            // Install the all-trusting trust manager
//            val sslContext: SSLContext = SSLContext.getInstance("SSL")
//            sslContext.init(null, trustAllCerts, SecureRandom())
//
//            // Create an ssl socket factory with our all-trusting manager
//            val sslSocketFactory: SSLSocketFactory = sslContext.socketFactory
//            val builder: OkHttpClient.Builder = OkHttpClient.Builder()
//            builder.sslSocketFactory(sslSocketFactory, trustAllCerts[0] as X509TrustManager)
//            builder.hostnameVerifier { hostname, session -> true }
//            builder
//        } catch (e: Exception) {
//            throw RuntimeException(e)
//        }
//    }
//
//    @Singleton
//    @Provides
//    fun provideOkHttpClient(@ApplicationContext context: Context): OkHttpClient {
//        val logger = HttpLoggingInterceptor()
//        logger.level = if (BuildConfig.DEBUG)
//            HttpLoggingInterceptor.Level.BODY
//        else
//            HttpLoggingInterceptor.Level.NONE
//        return getUnsafeOkHttpClient()
//            .callTimeout(120, TimeUnit.SECONDS)
//            .retryOnConnectionFailure(true)
//            .addInterceptor(NetWorkConnectionInterceptor(context))
//            .addInterceptor(logger)
//            .build()
//    }

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

    @Singleton
    @Provides
    fun providesApiServices(retrofit: Retrofit): ApiServices = retrofit.create(ApiServices::class.java)
}