package com.example.demo.service.impl

import com.example.demo.domain.User
import com.example.demo.domain.VerificationToken
import com.example.demo.repository.UserRepository
import com.example.demo.repository.VerificationTokenRepository
import com.example.demo.service.ConfirmService
import com.example.demo.service.EmailService
import com.example.demo.utils.now
import org.springframework.stereotype.Service
import java.util.*
import javax.transaction.Transactional

@Service
@Transactional
class ConfirmServiceImpl(
        private val emailService: EmailService,
        private val verificationTokenRepository: VerificationTokenRepository,
        private val userRepository: UserRepository
) : ConfirmService {

    override fun sendConfirmation(user: User) {
        val (uuid) = verificationTokenRepository.save(VerificationToken(
                expiredDate = now().plusDays(1),
                user = user
        ))
        emailService.sendConfirmation(user.email, "$uuid")
    }

    override fun confirm(token: UUID) {
        val (_, user, expiredTime) = verificationTokenRepository.findOne(token) ?: return
        if (expiredTime >= now())
            userRepository.save(user.copy(isEnabled = true))
        else
            sendConfirmation(user)
        verificationTokenRepository.delete(token)
    }
}