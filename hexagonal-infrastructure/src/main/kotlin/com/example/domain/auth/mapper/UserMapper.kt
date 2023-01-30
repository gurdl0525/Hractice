package com.example.domain.auth.mapper

import com.example.doamin.user.model.User
import com.example.domain.auth.entity.UserJpaEntity
import org.springframework.stereotype.Component

@Component
class UserMapper {

    fun toEntity(user: User): UserJpaEntity {
        return UserJpaEntity(
            user.id,
            user.accountId,
            user.password,
            user.name
        )
    }

}