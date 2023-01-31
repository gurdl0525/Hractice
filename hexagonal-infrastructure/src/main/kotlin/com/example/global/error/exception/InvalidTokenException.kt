package com.example.global.error.exception

import com.example.global.error.BusinessException
import com.example.global.error.data.GlobalErrorCode

class InvalidTokenException(): BusinessException(GlobalErrorCode.INVALID_TOKEN) {
    companion object {
        @JvmField
        val EXCEPTION = InvalidTokenException()
    }
}