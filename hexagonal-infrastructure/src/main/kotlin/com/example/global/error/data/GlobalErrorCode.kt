package com.example.global.error.data

import com.example.global.error.CustomErrorProperty
import org.springframework.http.HttpStatus

enum class GlobalErrorCode(
    private val message: String,
    private val status: HttpStatus
): CustomErrorProperty {

    INVALID_TOKEN("invalid token", HttpStatus.UNAUTHORIZED),
    EXPIRED_TOKEN("expired token", HttpStatus.UNAUTHORIZED),

    USER_NOT_FOUND("user not found", HttpStatus.NOT_FOUND),

    INTERNAL_SERVER_ERROR("internal server error", HttpStatus.INTERNAL_SERVER_ERROR)
    ;

    override fun status() = status.value()

    override fun message() = message
}