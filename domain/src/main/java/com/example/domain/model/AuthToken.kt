package com.example.domain.model

/**
 * 2023-05-03
 * pureum
 */
data class AuthToken(
    val access_token:String,
    val scope: String?,
    val token_type: String?
)
