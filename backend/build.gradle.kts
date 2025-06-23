plugins {
    java
    id("org.springframework.boot") version "3.2.0" // Specify a recent Spring Boot version
    id("io.spring.dependency-management") version "1.1.4"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17 // Or your preferred Java version
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    // Add other dependencies here as needed, for example:
    // implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    // implementation("org.springframework.boot:spring-boot-starter-security")
    // runtimeOnly("com.h2database:h2") // Example in-memory database
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

// Optional: Configure bootJar task if needed (e.g., for main class name if not standard)
/*
tasks.bootJar {
    mainClass.set("com.example.portfolio.PortfolioApplication")
    archiveFileName.set("my-portfolio-app.jar")
}
*/

// Optional: Add jib plugin for easy Docker image building if you want to go that route
/*
plugins {
    id("com.google.cloud.tools.jib") version "3.4.0"
}

jib {
    from {
        image = "eclipse-temurin:17-jre-jammy" // Or your preferred base image
    }
    to {
        image = "your-docker-hub-username/portfolio-backend" // Replace with your Docker image name
        tags = setOf(project.version.toString(), "latest")
    }
    container {
        ports = listOf("8080")
        mainClass = "com.example.portfolio.PortfolioApplication"
    }
}
*/
