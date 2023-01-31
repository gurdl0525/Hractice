package com.example.global.error.exception

import com.example.global.error.BusinessException
import com.example.global.error.data.GlobalErrorCode

class InternalServerErrorException(): BusinessException(GlobalErrorCode.INTERNAL_SERVER_ERROR) {

    companion object {
        @JvmField
        val EXCEPTION = InternalServerErrorException()
    }
}