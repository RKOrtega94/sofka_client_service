FROM openjdk:21-jdk-slim

WORKDIR /app

COPY build/libs/client-0.0.1-SNAPSHOT.jar /app/app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]