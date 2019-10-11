import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    java
    kotlin("jvm") version "1.3.41"
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
    implementation("org.javamoney", "moneta", "1.3")
    implementation("javax.validation", "validation-api", "2.0.1.Final")
    implementation("org.apache.logging.log4j", "log4j-api", "2.12.1")
    implementation("org.apache.logging.log4j", "log4j-core", "2.12.1")
    implementation("org.springframework.boot", "spring-boot-starter-data-mongodb", "2.1.9.RELEASE")
    implementation("org.springframework.data","spring-data-releasetrain","Moore-RELEASE")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}
tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}