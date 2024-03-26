plugins {
    id("org.springframework.boot") version "3.2.3"
    id("io.spring.dependency-management") version "1.1.4"
    kotlin("jvm") version "1.9.22"
    kotlin("plugin.spring") version "1.9.22"
    kotlin("plugin.jpa") version "1.9.22"
}

group = "site.algosipeosseong"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    //kotlin
    implementation(group = "com.fasterxml.jackson.module", name ="jackson-module-kotlin")
    implementation(group = "org.jetbrains.kotlin", name = "kotlin-reflect")

    //spring
    implementation(group = "org.springframework.boot", name = "spring-boot-starter-web")
    implementation(group = "org.springframework.boot", name = "spring-boot-starter-validation")
    implementation(group = "org.springframework.boot", name = "spring-boot-starter-data-jpa")
    implementation(group = "org.springframework.boot", name = "spring-boot-starter-security")

    //jwt
    implementation(group = "io.jsonwebtoken", name = "jjwt-api", version = "0.11.5")
    runtimeOnly(group = "io.jsonwebtoken", name = "jjwt-impl", version = "0.11.5")
    runtimeOnly(group = "io.jsonwebtoken", name = "jjwt-jackson", version = "0.11.5")

    //mysql
    runtimeOnly(group = "mysql", name = "mysql-connector-java", version="8.0.32")

    //redis
    implementation(group = "org.springframework.boot", name = "spring-boot-starter-data-redis")

    //test
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks {
    compileKotlin {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "17"
        }
    }

    compileJava {
        sourceCompatibility = JavaVersion.VERSION_17.majorVersion
    }

    test {
        useJUnitPlatform()
    }
}

allOpen {
    annotations("javax.persistence.Entity")
    annotation("javax.persistence.MappedSuperclass")
    annotation("javax.persistence.Embeddable")
}

noArg {
    annotations("javax.persistence.Entity")
    annotation("javax.persistence.MappedSuperclass")
    annotation("javax.persistence.Embeddable")
}


tasks.withType<Test> {
    useJUnitPlatform()
}
