package com.example.global.error

abstract class BusinessException(
    open val customErrorProperty: CustomErrorProperty
): RuntimeException() {
    override fun fillInStackTrace() = this
}