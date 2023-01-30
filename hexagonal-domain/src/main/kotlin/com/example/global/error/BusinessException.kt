package com.example.global.error

abstract class BusinessException(
    val errorProperty: ErrorProperty
): RuntimeException() {
    override fun fillInStackTrace() = this
}