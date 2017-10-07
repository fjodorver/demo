package com.example.demo

import com.example.demo.domain.toAuthUser
import com.example.demo.repository.UserRepository
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Bean
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters
import org.springframework.security.core.userdetails.UserDetailsService

@SpringBootApplication
@EntityScan(basePackageClasses = arrayOf(App::class, Jsr310JpaConverters::class))
class App {

    @Bean
    fun userService(userRepository: UserRepository) = UserDetailsService {
        userRepository.findOne(it).toAuthUser()
    }
}

fun main(args: Array<String>) {
    SpringApplication.run(App::class.java, *args)
}