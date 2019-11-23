FROM openjdk:12-alpine
WORKDIR /app
COPY build/libs/payment-service-0.1.jar /app/
ENTRYPOINT ["java", "-jar", "/app/payment-service-0.1.jar"]