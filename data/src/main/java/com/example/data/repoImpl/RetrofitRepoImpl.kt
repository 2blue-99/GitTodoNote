package com.example.data.repoImpl

import com.example.data.remote.dataSource.RetrofitSource
import com.example.data.remote.model.toAuthTokenResponse
import com.example.domain.model.AuthToken
import com.example.domain.repo.RetrofitRepo
import com.example.domain.usecase.RetrofitUseCase
import retrofit2.Response
import javax.inject.Inject

/**
 * 2023-05-03
 * pureum
 */
class RetrofitRepoImpl @Inject constructor(
    private val retrofitSource: RetrofitSource
) : RetrofitRepo {
    override suspend fun getAccessTokenRepo(
        code: String
    ): String {
//        return retrofitSource.getAccessToken(code = code).toAuthTokenResponse()
        return retrofitSource.getAccessToken(code = code)
    }
}