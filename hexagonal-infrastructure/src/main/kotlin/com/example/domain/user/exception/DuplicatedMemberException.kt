package com.example.domain.user.exception

import com.example.domain.common.error.DomainErrorCode
import com.example.global.error.BusinessException

class DuplicatedMemberException(): BusinessException(DomainErrorCode.DUPLICATED_MEMBER) {

    companion object {
        @JvmField
        val EXCEPTION = DuplicatedMemberException()
    }
}