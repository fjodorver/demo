import org.gradle.kotlin.dsl.*

plugins {
    `embedded-kotlin`
    kotlin("plugin.spring")
    kotlin("plugin.jpa")
    id("io.spring.dependency-management") version "1.0.3.RELEASE"
    id("org.springframework.boot") version "1.5.7.RELEASE"
}

repositories {
    jcenter()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation(kotlin("reflect"))
    implementation("org.flywaydb:flyway-core")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.security.oauth:spring-security-oauth2")
    runtime("org.springframework.boot:spring-boot-devtools")
    runtime("org.postgresql:postgresql")
}