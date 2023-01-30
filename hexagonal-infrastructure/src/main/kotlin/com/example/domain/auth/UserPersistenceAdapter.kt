package com.example.domain.auth

import com.example.doamin.user.model.User
import com.example.domain.auth.exception.DuplicatedMemberException
import com.example.domain.auth.mapper.UserMapper
import com.example.domain.auth.repository.UserJpaRepository
import com.example.domain.auth.spi.`in`.UserPort
import org.springframework.stereotype.Component

@Component
class UserPersistenceAdapter(
    private val userJpaRepository: UserJpaRepository,
    private val userMapper: UserMapper
): UserPort {
    override fun saveUser(user: User) {

        if(userJpaRepository.existsByAccountId(user.accountId)) {
            throw DuplicatedMemberException
        }

        userJpaRepository.save(userMapper.toEntity(user))
    }
}