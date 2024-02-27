# Use the official OpenJDK 11 image as base
FROM gradle:latest

# Set the working directory in the container
WORKDIR /app

# Copy the Gradle files to the container
COPY build.gradle .
COPY settings.gradle .

# Copy the Gradle wrapper files
COPY gradlew .

# Copy the source code into the container
COPY src src

# Build the application using Gradle
RUN gradle build

# Expose the port that the application will run on
EXPOSE 8080

# Command to run the application
CMD ["java", "-jar", "build/libs/sistema-pacientes-1.0.jar"]