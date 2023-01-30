package com.example.domain.auth.repository

import com.example.domain.auth.entity.UserJpaEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.transaction.annotation.Transactional

@Transactional(readOnly = true)
interface UserJpaRepository: JpaRepository<UserJpaEntity, Long> {
    fun existsByAccountId(accountId: String): Boolean
}