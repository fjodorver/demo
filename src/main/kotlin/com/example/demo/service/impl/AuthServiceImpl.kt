package com.example.demo.service.impl

import com.example.demo.domain.User
import com.example.demo.service.AuthService
import com.example.demo.service.ConfirmService
import org.springframework.security.oauth2.provider.OAuth2Authentication
import org.springframework.security.oauth2.provider.token.TokenStore
import org.springframework.stereotype.Service
import java.util.*
import javax.transaction.Transactional

@Service
@Transactional
class AuthServiceImpl(
        private val tokenStore: TokenStore,
        private val confirmService: ConfirmService
) : AuthService {

    override fun confirm(token: String) {
        confirmService.confirm(UUID.fromString(token))
    }

    override fun signUp(user: User) {
        confirmService.sendConfirmation(user)
    }

    override fun signOut(auth: OAuth2Authentication) {
        val accessToken = tokenStore.getAccessToken(auth) ?: return
        tokenStore.removeRefreshToken(accessToken.refreshToken ?: return)
        tokenStore.removeAccessToken(accessToken)
    }
}