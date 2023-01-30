package com.example.domain.user.entity

import javax.persistence.*

@Entity
class UserJpaEntity(
    id: Long?,
    accountId: String,
    password: String,
    name: String
){
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    val id: Long? = id

    @Column(nullable = false, length = 20)
    val accountId: String = accountId

    @Column(nullable = false, length = 60)
    val password: String = password

    @Column(nullable = false, length = 3)
    val name: String = name
}