package com.example.global.error.data

import com.example.global.error.CustomErrorProperty

enum class GlobalErrorCode(
    private val message: String,
    private val status: Int
): CustomErrorProperty {

    INVALID_TOKEN("invalid token", 401),
    EXPIRED_TOKEN("expired token", 401),

    USER_NOT_FOUND("user not found", 404),

    INTERNAL_SERVER_ERROR("internal server error", 500)
    ;

    override fun status() = status

    override fun message() = message
}