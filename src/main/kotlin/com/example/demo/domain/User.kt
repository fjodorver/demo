package com.example.demo.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import org.springframework.security.core.userdetails.UserDetails
import java.io.Serializable
import java.time.LocalDate
import javax.persistence.*
import org.springframework.security.core.userdetails.User as AuthUser

@Entity
@Table(name = "\"user\"")
data class User(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Int? = null,
        val email: String,
        val password: String,
        val birthday: LocalDate,
        @JsonIgnore
        val isEnabled: Boolean = false,
        val avatar: ByteArray? = null
) : Serializable {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        return id == (other as User).id
    }

    override fun hashCode(): Int = id ?: 0
}

fun User.toAuthUser(): UserDetails = AuthUser
        .withUsername(email)
        .password(password)
        .disabled(!isEnabled)
        .build()