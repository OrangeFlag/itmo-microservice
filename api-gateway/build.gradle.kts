plugins {
    java
    id("org.springframework.boot") version "2.2.1.RELEASE"
    id("io.spring.dependency-management") version "1.0.8.RELEASE"
}

group = "org.dei"
version = "0.0.1"
java.sourceCompatibility = JavaVersion.VERSION_1_8

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.cloud", "spring-cloud-starter-netflix-eureka-client")
    implementation("org.springframework.cloud", "spring-cloud-starter-netflix-turbine")
    implementation("org.springframework.cloud", "spring-cloud-starter-netflix-hystrix-dashboard")
    implementation("org.springframework.cloud", "spring-cloud-starter-netflix-zuul")
    testImplementation("org.springframework.boot", "spring-boot-starter-test") {
        exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
    }
}

dependencyManagement {
    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:Hoxton.RELEASE")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}