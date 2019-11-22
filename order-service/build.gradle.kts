plugins {
    java
    id("org.springframework.boot") version "2.2.1.RELEASE"
    id("io.spring.dependency-management") version "1.0.8.RELEASE"
}

group = "org.dei"
version = "0.1"

repositories {
    mavenCentral()
    maven { url = uri("https://repo.spring.io/milestone") }
}

dependencies {

    implementation("org.springframework.cloud", "spring-cloud-starter-openfeign", "2.1.3.RELEASE")
    implementation("org.springframework.cloud", "spring-cloud-starter-netflix-eureka-client", "2.1.3.RELEASE")
    implementation("org.springframework.boot", "spring-boot-starter-actuator", "2.1.3.RELEASE")
    implementation("org.javamoney", "moneta", "1.3")
    implementation("javax.validation", "validation-api", "2.0.1.Final")
    implementation("org.apache.logging.log4j", "log4j-api", "2.12.1")
    implementation("org.apache.logging.log4j", "log4j-core", "2.12.1")
    implementation("org.springframework.boot", "spring-boot-starter-data-jpa", "2.2.0.RELEASE")
    implementation("org.springframework.boot", "spring-boot-starter-web", "2.2.0.RELEASE")
    implementation("org.postgresql", "postgresql", "42.2.8")
    implementation("org.springframework.boot", "spring-boot-starter", "2.2.0.RELEASE")
    implementation("org.springframework.cloud", "spring-cloud-starter-netflix-ribbon", "2.0.0.RELEASE")
    implementation("org.modelmapper", "modelmapper", "2.3.5")
    implementation("javax.xml.bind", "jaxb-api", "2.3.1")
    implementation("com.google.code.gson", "gson", "2.8.6")
    implementation(project(":storehouse-service"))

    compileOnly("org.projectlombok:lombok:1.18.10")
    annotationProcessor("org.projectlombok:lombok:1.18.10")
}

dependencyManagement {
    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:Hoxton.RC2")
    }
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}