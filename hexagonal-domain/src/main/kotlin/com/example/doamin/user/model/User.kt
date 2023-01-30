package com.example.doamin.user.model

import com.example.global.annotation.Aggregate

@Aggregate
data class User(
    val id: Long?,
    val accountId: String,
    val password: String,
    val name: String
)