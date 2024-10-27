plugins {
    java
    `java-library`
    id("maven-publish")                 // Плагин для публикации в Nexus
    id("checkstyle")                    // Плагин для проверки стиля кода
    id("io.freefair.lombok") version "6.0.0-m2" // Плагин Lombok для упрощения кода
}

allprojects {
    version = "2.6.1"

    apply(plugin = "java")
    apply(plugin = "java-library")

    repositories {
        mavenCentral()
    }

    tasks.named<Test>("test") {
        useJUnitPlatform() // Поддержка JUnit Platform для тестов
    }

    dependencies {
        testImplementation(rootProject.libs.bundles.junit)
        testImplementation(rootProject.libs.mockito)
        testImplementation(rootProject.libs.assertj)
        testRuntimeOnly(rootProject.libs.junit.jupiter.engine)

        // Lombok для упрощения кода
        implementation("org.projectlombok:lombok:1.18.22")
        annotationProcessor("org.projectlombok:lombok:1.18.22")
    }
}

// Настройка Checkstyle
checkstyle {
    toolVersion = "8.45.1"
    config = resources.text.fromFile("config/checkstyle/checkstyle.xml")
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])
            groupId = "com.gdx.game"
            artifactId = "GdxGame"
            version = "1.0.0"
        }
    }

    repositories {
        maven {
            name = "localNexus"
            url = uri("http://localhost:8081/repository/maven-releases/")
        }
    }
}

project(":desktop") {
    dependencies {
        implementation(project(":core"))
        implementation(rootProject.libs.gdx.lwjgl3)
        implementation(variantOf(rootProject.libs.gdx.freetype.platform) { classifier("natives-desktop") })
    }
}

project(":core") {
    dependencies {
        implementation(rootProject.libs.gdx)
        implementation(variantOf(rootProject.libs.gdx.platform) { classifier("natives-desktop") })
        implementation(rootProject.libs.bundles.gdx.vfx)
        implementation(rootProject.libs.logback)
        testImplementation(rootProject.libs.gdx.backend.headless)
    }
}

