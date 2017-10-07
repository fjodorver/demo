package com.example.demo

import com.example.demo.domain.toAuthUser
import com.example.demo.repository.UserRepository
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.security.core.userdetails.UserDetailsService

@SpringBootApplication
class App {

    @Bean
    fun userService(userRepository: UserRepository) = UserDetailsService {
        userRepository.findOne(it).toAuthUser()
    }
}

fun main(args: Array<String>) {
    SpringApplication.run(App::class.java, *args)
}