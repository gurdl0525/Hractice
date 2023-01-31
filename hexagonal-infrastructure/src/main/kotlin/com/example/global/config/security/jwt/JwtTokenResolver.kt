package com.example.global.config.security.jwt

import org.springframework.stereotype.Component
import java.util.regex.Pattern
import javax.servlet.http.HttpServletRequest

@Component
class JwtTokenResolver {

    fun resolveToken(httpServletRequest: HttpServletRequest) = parseToken(
        httpServletRequest.getHeader("Authorization"),
        httpServletRequest.getHeader("type")
    )

    fun parseToken(token: String?, type: String?): String? {

        return if (token != null && Pattern.matches("Bearer [(a-zA-Z0-9-._~+/=*)]{30,600}", token) && type == "access") {
            token.substring(7)
        }
        else {
                null
        }
    }
}