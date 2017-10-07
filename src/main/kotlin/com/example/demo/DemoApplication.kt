package com.example.demo

import com.example.demo.domain.toAuthUser
import com.example.demo.repository.UserRepository
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore
import javax.sql.DataSource

@EnableAuthorizationServer
@EnableWebSecurity
@SpringBootApplication
class DemoApplication {

    @Bean
    fun userService(userRepository: UserRepository) = UserDetailsService {
        userRepository.findOne(it).toAuthUser()
    }

    @Bean
    fun tokenStore(@Qualifier("dataSource") dataSource: DataSource) = JdbcTokenStore(dataSource)
}

fun main(args: Array<String>) {
    SpringApplication.run(DemoApplication::class.java, *args)
}