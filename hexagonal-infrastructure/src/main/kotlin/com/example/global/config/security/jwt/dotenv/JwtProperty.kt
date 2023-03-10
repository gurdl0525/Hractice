package com.example.global.config.security.jwt.dotenv

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding
import java.util.*

@ConfigurationProperties("jwt")
@ConstructorBinding
class JwtProperty(
    secretKey: String,
    accessExp: Long,
    refreshExp: Long
) {
    val secretKey: String = Base64.getEncoder().encodeToString(secretKey.toByteArray())
    val accessExp: Long = accessExp * 1000
    val refreshExp: Long = refreshExp * 1000
}