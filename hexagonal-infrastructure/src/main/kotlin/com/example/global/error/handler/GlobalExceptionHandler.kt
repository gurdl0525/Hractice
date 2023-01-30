package com.example.global.error.handler

import com.example.global.error.BusinessException
import com.example.global.error.data.DefaultErrorResponse
import org.springframework.http.HttpStatus
import org.springframework.validation.BindException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BindException::class)
    protected fun bindException(e: BindException): DefaultErrorResponse{
            return DefaultErrorResponse(
                status = 400,
                message = e.message
            )
    }

    @ExceptionHandler(BusinessException::class)
    protected fun businessException(e: BusinessException): DefaultErrorResponse{
        val property = e.customErrorProperty
        return DefaultErrorResponse(
            status = property.status(),
            message = property.message()
        )
    }
}