package com.example.domain.usecase

import com.example.domain.model.AuthToken
import com.example.domain.repo.RetrofitRepo

/**
 * 2023-05-03
 * pureum
 */

class RetrofitUseCase (
    private val retrofitRepo: RetrofitRepo
    ) {
    suspend fun getAccessTokenUseCase(
        code: String
    ): String{
        return retrofitRepo.getAccessTokenRepo(code)
    }
}