package com.example.global.config.filter

import com.example.global.error.BusinessException
import com.example.global.error.CustomErrorProperty
import com.example.global.error.data.DefaultErrorResponse
import com.example.global.error.exception.InternalServerErrorException
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import java.io.IOException
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class HandlerFilter(
    private val objectMapper: ObjectMapper
): OncePerRequestFilter() {

    @Throws(IOException::class)
    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {

        try {
            filterChain.doFilter(request, response)
        } catch (e: Exception) {
            e.printStackTrace()

            when(e) {
                is BusinessException -> sendErrorResponse(response, e.customErrorProperty)
                else -> sendErrorResponse(response, InternalServerErrorException.EXCEPTION.customErrorProperty)
            }
        }
    }

    @Throws(IOException::class)
    private fun sendErrorResponse(response: HttpServletResponse, property: CustomErrorProperty) {
        response.status = property.status()
        response.contentType = MediaType.APPLICATION_JSON_VALUE
        response.writer.write(
            objectMapper.writeValueAsString(
                DefaultErrorResponse(property.status(), property.message())
            )
        )
    }
}