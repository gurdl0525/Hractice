package com.example.domain.common.error

import com.example.global.error.CustomErrorProperty

enum class DomainErrorCode(
    private val message: String,
    private val status: Int
): CustomErrorProperty {

    DUPLICATED_MEMBER("AUTH-01", 400)
    ;

    override fun message() = message

    override fun status() = status
}