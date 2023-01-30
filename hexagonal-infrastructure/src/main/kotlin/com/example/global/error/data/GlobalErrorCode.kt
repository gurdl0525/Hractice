package com.example.global.error.data

import com.example.global.error.CustomErrorProperty

enum class GlobalErrorCode(
    private val message: String,
    private val status: Int
): CustomErrorProperty {

    ;

    override fun status() = status

    override fun message() = message
}