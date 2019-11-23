FROM openjdk:12-alpine
WORKDIR /app
COPY build/libs/order-service-0.1.jar /app/
ENTRYPOINT ["java", "-jar", "/app/order-service-0.1.jar"]