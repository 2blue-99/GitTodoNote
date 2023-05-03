package com.example.data.remote.dataSource

import com.example.data.BuildConfig
import com.example.data.remote.model.AuthTokenResponse
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

/**
 * 2023-05-03
 * pureum
 */
interface RetrofitSource {
    @FormUrlEncoded
    @POST("access_token")
    suspend fun getAccessToken(
        @Field("client_id") clientId: String = BuildConfig.GITHUB_ID,
        @Field("client_secret") clientSecret: String = BuildConfig.GITHUB_PW,
        @Field("code") code: String
    ): String
}