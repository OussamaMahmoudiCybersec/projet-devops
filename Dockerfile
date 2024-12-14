# Use a lightweight JDK base image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the jar file from the host to the container
COPY target/*.jar app.jar

# Expose the application's port
EXPOSE 6969

# Set the default command to run the jar
ENTRYPOINT ["java", "-jar", "app.jar"]
