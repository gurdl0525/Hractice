package com.example.domain.auth.spi.out

import com.example.domain.auth.dto.response.TokenResponse

interface UserJwtPort {
    fun receiveToken(accountId: String): TokenResponse
}