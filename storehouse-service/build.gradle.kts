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
    testCompile("junit", "junit", "4.12")
    compile("org.springframework.boot", "spring-boot-starter")
    implementation("org.springframework.cloud", "spring-cloud-starter-netflix-hystrix")
    implementation("org.springframework.cloud", "spring-cloud-starter-openfeign")
    implementation("org.springframework.cloud", "spring-cloud-starter-netflix-eureka-client")
    implementation("org.springframework.boot", "spring-boot-starter-actuator")
    implementation("org.springframework.boot", "spring-boot-starter-data-jpa")
    implementation("org.springframework.boot", "spring-boot-starter-web")
    implementation("org.springframework.amqp", "spring-rabbit")
    implementation("org.springframework.boot", "spring-boot-starter-amqp")

    implementation("javax.validation", "validation-api", "2.0.1.Final")
    implementation("org.apache.logging.log4j", "log4j-api", "2.12.1")
    implementation("org.apache.logging.log4j", "log4j-core", "2.12.1")
    runtime("org.postgresql", "postgresql", "9.4-1206-jdbc42")
    implementation("org.modelmapper", "modelmapper", "2.3.5")
    compileOnly("org.projectlombok", "lombok", "1.18.10")
    annotationProcessor("org.projectlombok", "lombok", "1.18.10")
    implementation("javax.xml.bind", "jaxb-api", "2.3.1")
    implementation("com.google.code.gson", "gson", "2.8.6")

    implementation(project(":storehouse-api"))
    implementation(project(":messages"))
}

dependencyManagement {
    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:Hoxton.RELEASE")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
