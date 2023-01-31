package com.example.global.error.exception

import com.example.global.error.BusinessException
import com.example.global.error.data.GlobalErrorCode

class UserNotFoundException(): BusinessException(GlobalErrorCode.USER_NOT_FOUND) {
    companion object {
        @JvmField
        val EXCEPTION = UserNotFoundException()
    }
}