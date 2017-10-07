package com.example.demo.service

import com.example.demo.domain.User
import com.example.demo.repository.UserRepository
import org.springframework.security.oauth2.provider.OAuth2Authentication
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices
import org.springframework.security.oauth2.provider.token.DefaultTokenServices
import org.springframework.stereotype.Service

@Service
class AuthService(tokenServices: ConsumerTokenServices, private val userRepository: UserRepository) {

    private val tokenServices = tokenServices as DefaultTokenServices

    fun signUp(user: User){
        userRepository.save(user)
    }

    fun signOut(auth: OAuth2Authentication): Boolean {
        val accessToken = tokenServices.getAccessToken(auth).value
        return tokenServices.revokeToken(accessToken)
    }
}