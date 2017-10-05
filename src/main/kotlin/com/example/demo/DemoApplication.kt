package com.example.demo

import com.example.demo.domain.toAuthUser
import com.example.demo.repository.UserRepository
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer

@EnableAuthorizationServer
@EnableWebSecurity
@SpringBootApplication
class DemoApplication {

    @Bean
    fun userService(userRepository: UserRepository) = UserDetailsService {
        userRepository.findById(it)
                .orElseThrow { UsernameNotFoundException(it) }
                .toAuthUser()
    }
}

fun main(args: Array<String>) {
    SpringApplication.run(DemoApplication::class.java, *args)
}