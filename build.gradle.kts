
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
        "implementation"("org.modelmapper", "modelmapper", "2.3.5")
        "compileOnly"("org.projectlombok", "lombok", "1.18.10")
        "annotationProcessor"("org.projectlombok", "lombok", "1.18.10")
    }

}