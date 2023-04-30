FROM gradle:8.1-jdk17

WORKDIR /usr/src/entity
COPY build.gradle settings.gradle ./
RUN gradle classes

COPY src ./src
RUN gradle build -xtest
