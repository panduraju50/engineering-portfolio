# Use an official OpenJDK runtime as a parent image
FROM eclipse-temurin:17-jre-jammy

# Set the working directory in the container
WORKDIR /app

# Copy the fat jar from the build stage to the current directory in the container
# Assumes your Spring Boot fat JAR is built in backend/build/libs/ and ends with .jar
# Adjust the JAR name if it's different (e.g., if you customized archiveFileName in build.gradle.kts)
COPY build/libs/*-SNAPSHOT.jar app.jar
# If you have a fixed name like 'my-portfolio-app.jar':
# COPY build/libs/my-portfolio-app.jar app.jar

# Make port 8080 available to the world outside this container
EXPOSE 8080

# Run the jar file
ENTRYPOINT ["java", "-jar", "app.jar"]
