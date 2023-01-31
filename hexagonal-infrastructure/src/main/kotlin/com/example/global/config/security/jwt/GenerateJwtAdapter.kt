package com.example.global.config.security.jwt

import com.example.domain.auth.dto.response.TokenResponse
import com.example.domain.auth.spi.out.UserJwtPort
import com.example.global.config.security.jwt.dotenv.JwtProperty
import com.example.global.persistence.redis.entity.RefreshToken
import com.example.global.persistence.redis.repository.RefreshTokenRepository
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.stereotype.Component
import java.util.*

@Component
class GenerateJwtAdapter(
    private val jwtProperty: JwtProperty,
    private val refreshTokenRepository: RefreshTokenRepository
) : UserJwtPort{

    companion object {
        private const val REFRESH_KEY = "refresh"
        private const val ACCESS_KEY = "access"
    }

    override fun receiveToken(accountId: String) = TokenResponse(
        accessToken = generateToken(accountId),
        refreshToken = generateRefreshToken(accountId)
    )

    private fun generateRefreshToken(accountId: String): String {

        val newRefreshToken = Jwts.builder()
            .signWith(SignatureAlgorithm.HS256, jwtProperty.secretKey)
            .setHeaderParam("type", REFRESH_KEY)
            .setIssuedAt(Date())
            .setExpiration(Date(System.currentTimeMillis() + jwtProperty.refreshExp))
            .compact()

        refreshTokenRepository.save(
            RefreshToken(
                accountId = accountId,
                token = newRefreshToken
            )
        )

        return newRefreshToken
    }

    private fun generateToken(accountId: String): String {
        return Jwts.builder()
            .signWith(SignatureAlgorithm.HS256, jwtProperty.secretKey)
            .setSubject(accountId)
            .setHeaderParam("type", ACCESS_KEY)
            .setIssuedAt(Date())
            .setExpiration(Date(System.currentTimeMillis() + jwtProperty.accessExp))
            .compact()
    }
}