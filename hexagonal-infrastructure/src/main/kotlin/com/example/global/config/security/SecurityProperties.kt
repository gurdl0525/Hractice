package com.example.global.config.security

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding
import java.util.*

@ConfigurationProperties("spring.jwt")
@ConstructorBinding
class SecurityProperties(
    accessExp: Long,
    refreshExp: Long,
    secret: String
) {
    val accessExp: Long = accessExp * 1000
    val refreshExp: Long = refreshExp * 1000
    val secretKey: String = Base64.getEncoder().encodeToString(secret.toByteArray())
}