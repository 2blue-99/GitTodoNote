package com.example.data.remote.model

import com.example.domain.model.AuthToken

/**
 * 2023-05-03
 * pureum
 */
data class  AuthTokenResponse(
    val access_token: String,
    val expires_in: Int,
    val refresh_token: String? = null,
    val refresh_token_expires_in: Int,
    val scope: String? = null,
    val token_type: String? = null
)

fun AuthTokenResponse.toAuthTokenResponse():AuthToken = AuthToken(
    access_token = access_token,
    scope = scope,
    token_type = token_type)

