package com.example.global.config.redis.entity

import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash
import org.springframework.data.redis.core.index.Indexed

@RedisHash(value = "RefreshToken", timeToLive = 60 * 60 * 24 * 7)
data class RefreshToken (

    @Id
    val accountId: String,

    @Indexed
    val token: String
)