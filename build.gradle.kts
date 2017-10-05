import org.gradle.kotlin.dsl.*

buildscript {
    repositories {
        mavenCentral()
        maven(url = "https://repo.spring.io/milestone")
        maven(url = "https://repo.spring.io/snapshot")
        jcenter()
    }
    dependencies {
        classpath("org.springframework.boot:spring-boot-gradle-plugin:2.0.0.M4")
    }
}

apply {
    plugin("org.springframework.boot")
    plugin("io.spring.dependency-management")
}

plugins {
    val kotlinVersion = "1.1.51"
    kotlin(module = "jvm", version = kotlinVersion)
    kotlin(module = "plugin.spring", version = kotlinVersion)
    kotlin(module = "plugin.noarg", version = kotlinVersion)
    id("io.spring.dependency-management") version "1.0.3.RELEASE"
}

repositories {
    mavenCentral()
    maven(url = "https://repo.spring.io/milestone")
    maven(url = "https://repo.spring.io/snapshot")
    jcenter()
}

dependencies {
    val kotlinVersion = "1.1.51"
    implementation(group = "org.springframework.boot", name = "spring-boot-starter-web")
    implementation(group = "org.springframework.boot", name = "spring-boot-starter-data-jpa")
    implementation(group = "org.springframework.boot", name = "spring-boot-starter-security")
    implementation(group = "org.springframework.security.oauth", name = "spring-security-oauth2")
    implementation(kotlin(module = "stdlib", version = kotlinVersion))
    implementation(kotlin(module = "reflect", version = kotlinVersion))
    runtime(group = "org.springframework.boot", name = "spring-boot-devtools")
    runtime(group = "com.h2database", name = "h2")
}