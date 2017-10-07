package com.example.demo.controller

import com.example.demo.domain.User
import com.example.demo.service.AuthService
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.oauth2.provider.OAuth2Authentication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class AuthController(private val authService: AuthService) {

    @PostMapping("/signup")
    fun signUp(@AuthenticationPrincipal user: User){
        authService.signUp(user)
    }

    @GetMapping("/signin")
    fun signOut(auth: OAuth2Authentication) {
        authService.signOut(auth)
    }
}