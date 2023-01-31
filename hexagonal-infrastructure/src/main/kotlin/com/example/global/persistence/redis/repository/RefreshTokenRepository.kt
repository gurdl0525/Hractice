package com.example.global.persistence.redis.repository

import com.example.global.persistence.redis.entity.RefreshToken
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*


@Repository
interface RefreshTokenRepository: CrudRepository<RefreshToken, String> {

    override fun findById(id: String): Optional<RefreshToken?>
}