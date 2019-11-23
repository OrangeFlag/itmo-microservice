FROM openjdk:12-alpine
WORKDIR /app
COPY build/libs/storehouse-service-0.1.jar /app/
ENTRYPOINT ["java", "-jar", "/app/storehouse-service-0.1.jar"]