package com.example.demo.domain

import org.springframework.security.core.userdetails.UserDetails
import java.io.Serializable
import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.Id
import org.springframework.security.core.userdetails.User as AuthUser

@Entity
data class User(
        @Id
        val username: String,
        val password: String,
        val birthday: LocalDateTime,
        val isEnabled: Boolean = false
) : Serializable

fun User.toAuthUser(): UserDetails = AuthUser
        .withUsername(username)
        .password(password)
        .disabled(!isEnabled)
        .build()