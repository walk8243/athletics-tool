FROM gradle:8.1-jdk17 AS builder

WORKDIR /usr/src/app
COPY build.gradle settings.gradle ./
RUN gradle classes

COPY src ./src
RUN gradle build -xtest

FROM openjdk:17.0

COPY --from=builder /usr/src/app/build/libs/web-api.jar /usr/app.jar

CMD ["java", "-jar", "/usr/app.jar"]
