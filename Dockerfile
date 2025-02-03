# Stage 1: Build stage using JDK 17
FROM openjdk:17-jdk AS build
WORKDIR /app

# Copy Maven files to cache dependencies
COPY pom.xml .
COPY mvnw .
COPY .mvn .mvn
RUN chmod +x ./mvnw
RUN ./mvnw dependency:go-offline

# Copy project files and build the application
COPY src src
RUN ./mvnw clean package -DskipTests

# Stage 2: Create final image using JDK 17
FROM openjdk:17-jdk
WORKDIR /app
VOLUME /tmp

# Copy the built JAR from the previous stage
COPY --from=build /app/target/*.jar app.jar

# Expose the correct port
EXPOSE 8083

# Run the application
ENTRYPOINT ["java", "-jar", "/app.jar"]
