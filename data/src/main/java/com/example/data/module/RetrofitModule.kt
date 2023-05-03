package com.example.data.module

import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * 2023-05-03
 * pureum
 */


@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    private var gson = GsonBuilder().setLenient().create()

    @Provides
    @Singleton
    fun retrofitProvider(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://github.com/login/oauth/")
            .client(okHttpClient)
            .addConverterFactory(ScalarsConverterFactory.create()) //string으로 받기
//            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    private val okHttpClient = OkHttpClient.Builder().
    addInterceptor(HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }).addInterceptor {
        val request = it.request()
            .newBuilder()
            .build()
        val response = it.proceed(request)
        response
    }.connectTimeout(20, TimeUnit.SECONDS).
    readTimeout(20, TimeUnit.SECONDS).
    writeTimeout(20, TimeUnit.SECONDS).
    build()
}