package com.example.domain.user.repository

import com.example.domain.user.entity.UserJpaEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.transaction.annotation.Transactional

@Transactional(readOnly = true)
interface UserJpaRepository: JpaRepository<UserJpaEntity, Long> {

    fun existsByAccountId(accountId: String): Boolean

    fun findByAccountId(accountId: String): UserJpaEntity?

}