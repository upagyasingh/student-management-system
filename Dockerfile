# Use Java 20 as base image
FROM openjdk:20-jdk

# Set working directory
WORKDIR /app

# Copy JAR file
COPY dist/StudentManagement.jar StudentManagement.jar

# Expose port (if applicable)
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "StudentManagement.jar"]
