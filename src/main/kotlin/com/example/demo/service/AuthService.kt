package com.example.demo.service

import com.example.demo.domain.User
import com.example.demo.repository.UserRepository
import org.springframework.security.oauth2.provider.OAuth2Authentication
import org.springframework.security.oauth2.provider.token.DefaultTokenServices
import org.springframework.stereotype.Service

@Service
class AuthService(private val tokenServices: DefaultTokenServices, private val userRepository: UserRepository) {

    fun signUp(user: User){
        userRepository.save(user)
    }

    fun signOut(auth: OAuth2Authentication) {
        tokenServices.revokeToken(tokenServices.getAccessToken(auth).value)
    }
}