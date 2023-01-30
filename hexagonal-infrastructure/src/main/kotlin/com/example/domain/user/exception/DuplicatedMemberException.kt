package com.example.domain.user.exception

import com.example.domain.common.error.DomainErrorCode
import com.example.global.error.BusinessException

object DuplicatedMemberException: BusinessException(DomainErrorCode.DUPLICATED_MEMBER)