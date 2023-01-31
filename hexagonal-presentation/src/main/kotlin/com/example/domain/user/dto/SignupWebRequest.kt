package com.example.domain.user.dto

import com.example.global.regex.PasswordRegex
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Pattern
import jakarta.validation.constraints.Size

data class SignupWebRequest(

    @field:NotBlank
    @field:Size(min = 10, max = 20, message = "10 ~ 20 글자를 입력해야 합니다")
    val accountId: String,

    @field:NotBlank
    @field:Pattern(
        regexp = PasswordRegex.REGEX,
        message = "최소 8자, 하나 이상의 문자, 하나의 이상의 숫자 및 하나의 이상의 특수 문자"
    )
    val password: String,

    @field:NotBlank
    @field:Size(min = 2, max = 4, message = "이름은 2 ~ 4 글자 입니다")
    val name: String
)
