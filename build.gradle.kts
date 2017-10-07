import org.gradle.kotlin.dsl.*

plugins {
    `embedded-kotlin`
    kotlin(module = "plugin.spring")
    kotlin(module = "plugin.jpa")
    id("io.spring.dependency-management") version "1.0.3.RELEASE"
    id("org.springframework.boot") version "1.5.7.RELEASE"
}

repositories {
    jcenter()
}

dependencies {
    implementation(group = "org.springframework.boot", name = "spring-boot-starter-web")
    implementation(group = "org.springframework.boot", name = "spring-boot-starter-data-jpa")
    implementation(group = "org.springframework.boot", name = "spring-boot-starter-security")
    implementation(group = "org.springframework.security.oauth", name = "spring-security-oauth2")
    implementation(kotlin(module = "stdlib"))
    implementation(kotlin(module = "reflect"))
    runtime(group = "org.springframework.boot", name = "spring-boot-devtools")
    runtime(group = "org.postgresql", name = "postgresql")
}