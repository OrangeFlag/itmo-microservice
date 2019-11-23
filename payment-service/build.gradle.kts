import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    java
    kotlin("jvm") version "1.3.41"
    id("org.springframework.boot") version "2.2.1.RELEASE"
}

group = "org.dei"
version = "0.1"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    testCompile("junit", "junit", "4.12")
    implementation("org.springframework.cloud", "spring-cloud-starter-openfeign", "2.1.3.RELEASE")
    implementation("org.springframework.cloud", "spring-cloud-starter-netflix-eureka-client", "2.1.3.RELEASE")
    implementation("org.springframework.boot","spring-boot-starter-actuator", "2.1.3.RELEASE")
    implementation("org.javamoney", "moneta", "1.3")
    implementation("org.apache.logging.log4j", "log4j-api", "2.12.1")
    implementation("org.apache.logging.log4j", "log4j-core", "2.12.1")
    implementation("javax.validation", "validation-api", "2.0.1.Final")
    implementation("org.apache.logging.log4j", "log4j-api", "2.12.1")
    implementation("org.apache.logging.log4j", "log4j-core", "2.12.1")
    implementation("org.springframework.boot", "spring-boot-starter-data-jpa", "2.2.0.RELEASE")
    implementation("org.springframework.boot", "spring-boot-starter-web", "2.2.0.RELEASE")
    runtime("org.postgresql", "postgresql", "9.4-1206-jdbc42")
    compile("org.springframework.boot:spring-boot-starter")
    implementation("javax.xml.bind", "jaxb-api", "2.3.1")
    implementation("com.google.code.gson", "gson", "2.8.6")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}
tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}
