package com.example.demo.service

import com.example.demo.domain.User
import java.util.*

interface ConfirmService {

    fun confirm(token: UUID)

    fun sendConfirmation(user: User)
}