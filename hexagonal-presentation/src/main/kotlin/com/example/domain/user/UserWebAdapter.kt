package com.example.domain.user

import com.example.domain.auth.dto.request.SignUpRequest
import com.example.domain.auth.usecase.SignUpUseCase
import com.example.domain.user.dto.SignupWebRequest
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@Validated
@RestController
@RequestMapping("/users")
class UserWebAdapter(
    private val signUpUseCase: SignUpUseCase
) {

    @PostMapping("/auth")
    @ResponseStatus(HttpStatus.CREATED)
    fun signUp(
        @RequestBody @Valid
        request: SignupWebRequest
    ){
        signUpUseCase.execute(
            SignUpRequest(
                request.accountId,
                request.password,
                request.name
            )
        )
    }
}