package com.example.demo.controller

import com.example.demo.domain.User
import com.example.demo.service.AuthService
import org.springframework.security.oauth2.provider.OAuth2Authentication
import org.springframework.web.bind.annotation.*

@RestController
class AuthController(private val authService: AuthService) {

    @GetMapping("/confirm")
    fun confirm(@RequestParam token: String) {
        authService.confirm(token)
    }

    @PostMapping("/signup")
    fun signUp(@RequestBody user: User){
        authService.signUp(user)
    }

    @GetMapping("/signout")
    fun signOut(auth: OAuth2Authentication) {
        authService.signOut(auth)
    }
}