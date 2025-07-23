FROM openjdk:17-jdk-slim

WORKDIR /app

# Copy Maven wrapper and pom.xml
COPY mvnw pom.xml ./
COPY .mvn .mvn

# Copy source code
COPY src src

# Make Maven wrapper executable
RUN chmod +x ./mvnw

# Build the application
RUN ./mvnw clean package -DskipTests

# Expose port (Render will set the PORT environment variable)
EXPOSE 8080

# Run the application with dynamic port binding
CMD ["sh", "-c", "java -Dserver.port=${PORT:-8080} -jar target/projectmanagement-0.0.1-SNAPSHOT.jar"]
