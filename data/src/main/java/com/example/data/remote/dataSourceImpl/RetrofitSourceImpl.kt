package com.example.data.remote.dataSourceImpl

import android.util.Log
import com.example.data.remote.dataSource.RetrofitSource
import com.example.data.remote.model.AuthTokenResponse
import retrofit2.Response
import retrofit2.Retrofit
import javax.inject.Inject

/**
 * 2023-05-03
 * pureum
 */
class RetrofitSourceImpl @Inject constructor(
    private val retrofit:Retrofit
):RetrofitSource {
    override suspend fun getAccessToken(
        clientId: String,
        clientSecret: String,
        code: String
    ): String {
        var gap = retrofit.create(RetrofitSource::class.java).getAccessToken(clientId = clientId, clientSecret = clientSecret, code = code)
        Log.e("TAG", "retrofitImpl : $gap", )
        return gap
    }
}