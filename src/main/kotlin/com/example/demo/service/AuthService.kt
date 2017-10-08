package com.example.demo.service

import com.example.demo.domain.User
import org.springframework.security.oauth2.provider.OAuth2Authentication

interface AuthService {

    fun confirm(token: String)

    fun signUp(user: User)

    fun signOut(auth: OAuth2Authentication)
}