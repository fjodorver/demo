import org.gradle.kotlin.dsl.*

plugins {
    `embedded-kotlin`
    kotlin("plugin.spring") version embeddedKotlinVersion
    kotlin("plugin.jpa") version embeddedKotlinVersion
    id("io.spring.dependency-management") version "1.0.3.RELEASE"
    id("org.springframework.boot") version "1.5.7.RELEASE"
}

repositories {
    jcenter()
}

dependencies {
    implementation(kotlin("stdlib", embeddedKotlinVersion))
    implementation(kotlin("reflect", embeddedKotlinVersion))
    implementation("org.flywaydb:flyway-core")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.boot:spring-boot-starter-mail")
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
    implementation("org.springframework.security.oauth:spring-security-oauth2")
    runtime("org.springframework.boot:spring-boot-devtools")
    runtime("org.postgresql:postgresql")
}