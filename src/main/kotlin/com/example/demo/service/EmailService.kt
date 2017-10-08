package com.example.demo.service

interface EmailService {

    fun sendConfirmation(email: String, token: String)
}