package com.example.demo.domain

import org.springframework.security.core.userdetails.UserDetails
import java.io.Serializable
import java.time.LocalDate
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table
import org.springframework.security.core.userdetails.User as AuthUser

@Entity
@Table(name = "\"user\"")
data class User(
        @Id
        val email: String,
        val password: String,
        val birthday: LocalDate,
        val isEnabled: Boolean = false
) : Serializable

fun User.toAuthUser(): UserDetails = AuthUser
        .withUsername(email)
        .password(password)
        .disabled(!isEnabled)
        .build()