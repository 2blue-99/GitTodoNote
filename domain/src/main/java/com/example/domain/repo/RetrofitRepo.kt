package com.example.domain.repo

import com.example.domain.model.AuthToken

/**
 * 2023-05-03
 * pureum
 */
interface RetrofitRepo {
    suspend fun getAccessTokenRepo(
        code: String
    ):String
}