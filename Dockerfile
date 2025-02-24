# Use the official OpenJDK image
FROM openjdk:17-jdk

# Set the working directory inside the container
WORKDIR /app

# Copy the built JAR file into the container
COPY dist/StudentManagement.jar /app/StudentManagement.jar

# Run the JAR file
CMD ["java", "-jar", "StudentManagement.jar"]
