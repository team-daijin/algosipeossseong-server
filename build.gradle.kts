plugins {
    alias(libs.plugins.spring.boot)
    alias(libs.plugins.spring.management)
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.kotlin.spring)
    alias(libs.plugins.kotlin.jpa)
}

group = "site.algosipeosseong"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.bundles.kotlin)
    implementation(libs.bundles.spring)
    implementation(libs.bundles.jjwt.impl)
    implementation(libs.bundles.jjwt.runtime)
    implementation(libs.connector.mysql)
    implementation(libs.redis)
    implementation(libs.bundles.jackson)
    implementation(libs.spring.aws)
    testImplementation(libs.bundles.test)
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