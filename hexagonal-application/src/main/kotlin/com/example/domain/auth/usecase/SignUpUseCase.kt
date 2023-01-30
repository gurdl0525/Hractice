package com.example.domain.auth.usecase

import com.example.doamin.user.model.User
import com.example.domain.auth.dto.request.SignUpRequest
import com.example.domain.auth.spi.`in`.UserPort
import com.example.global.annotation.UseCase

@UseCase
class SignUpUseCase(
    private val userPort: UserPort
) {
    fun execute(signUpRequest: SignUpRequest){
        val user = User(
            id = null,
            accountId = signUpRequest.accountId,
            password = signUpRequest.password,
            name = signUpRequest.name
        )
        userPort.saveUser(user)
    }
}