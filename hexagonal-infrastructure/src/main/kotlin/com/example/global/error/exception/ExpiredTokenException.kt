package com.example.global.error.exception

import com.example.global.error.BusinessException
import com.example.global.error.data.GlobalErrorCode

class ExpiredTokenException(): BusinessException(GlobalErrorCode.EXPIRED_TOKEN) {

    companion object {
        @JvmField
        val EXCEPTION = ExpiredTokenException()
    }
}