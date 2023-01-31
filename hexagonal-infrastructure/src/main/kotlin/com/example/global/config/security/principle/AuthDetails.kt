package com.example.global.config.security.principle

import com.example.domain.user.entity.UserJpaEntity
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class AuthDetails(
    private val user: UserJpaEntity
): UserDetails {
    override fun getAuthorities(): MutableCollection<GrantedAuthority> = mutableListOf()

    override fun getPassword() = user.password

    override fun getUsername() = user.accountId

    override fun isAccountNonExpired() = false

    override fun isAccountNonLocked() = false

    override fun isCredentialsNonExpired() = false

    override fun isEnabled() = false
}