package com.example.demo.domain

import org.hibernate.annotations.Cascade
import org.hibernate.annotations.CascadeType
import java.io.Serializable
import java.time.LocalDateTime
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "verification_token")
data class VerificationToken(
        @Id
        @GeneratedValue
        val key: UUID? = null,
        @Cascade(CascadeType.PERSIST)
        @OneToOne(targetEntity = User::class)
        val user: User,
        val expiredDate: LocalDateTime
) : Serializable