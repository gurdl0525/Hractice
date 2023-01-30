package com.example.domain.auth.spi.`in`

import com.example.doamin.user.model.User

interface UserPort {
    fun saveUser(user: User)
}