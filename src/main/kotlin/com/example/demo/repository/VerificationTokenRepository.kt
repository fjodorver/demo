package com.example.demo.repository

import com.example.demo.domain.VerificationToken
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface VerificationTokenRepository : JpaRepository<VerificationToken, UUID>