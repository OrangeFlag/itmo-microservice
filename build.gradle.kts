
allprojects{
    apply(plugin = "java")
    group = "org.dei"
    version = "0.1"
}


subprojects {
    repositories {
        mavenCentral()
        jcenter()
    }

    dependencies {
        "implementation"("org.springframework.cloud", "spring-cloud-starter-openfeign", "2.1.3.RELEASE")
        "implementation"("javax.validation", "validation-api", "2.0.1.Final")
        "implementation"("org.apache.logging.log4j", "log4j-api", "2.12.1")
        "implementation"("org.apache.logging.log4j", "log4j-core", "2.12.1")
        "implementation"("org.springframework.boot", "spring-boot-starter-data-jpa", "2.2.0.RELEASE")
        "implementation"("org.springframework.boot", "spring-boot-starter-web", "2.2.0.RELEASE")
        "implementation"("org.postgresql", "postgresql", "42.2.8")
        "implementation"("org.springframework.boot", "spring-boot-starter", "2.2.0.RELEASE")
        "implementation"("org.modelmapper", "modelmapper", "2.3.5")
        "compileOnly"("org.projectlombok", "lombok", "1.18.10")
        "annotationProcessor"("org.projectlombok", "lombok", "1.18.10")
    }

}