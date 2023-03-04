package com.example.domain.common.error

import com.example.global.error.CustomErrorProperty
import org.springframework.http.HttpStatus

enum class DomainErrorCode(
    private val message: String,
    private val status: HttpStatus
): CustomErrorProperty {

    DUPLICATED_MEMBER("duplicated member", HttpStatus.BAD_REQUEST)
    ;

    override fun status() = status.value()

    override fun message() = message
}