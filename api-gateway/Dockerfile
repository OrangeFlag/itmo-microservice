FROM openjdk:12-alpine
WORKDIR /app
COPY build/libs/api-gateway-0.0.1.jar ./
ENTRYPOINT ["java", "-jar", "/app/api-gateway-0.0.1.jar"]