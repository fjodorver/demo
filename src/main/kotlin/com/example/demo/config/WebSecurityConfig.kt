package com.example.demo.config

import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore
import javax.sql.DataSource

@EnableAuthorizationServer
@EnableResourceServer
@EnableWebSecurity
@Configuration
class WebSecurityConfig: WebSecurityConfigurerAdapter() {

    @Bean
    fun tokenStore(@Qualifier("dataSource") dataSource: DataSource) = JdbcTokenStore(dataSource)

    override fun configure(http: HttpSecurity) {

    }
}