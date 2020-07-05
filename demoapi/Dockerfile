FROM maven:3-jdk-11

RUN mkdir /app
WORKDIR /app

COPY src ./src
COPY pom.xml ./

EXPOSE 8080
ENTRYPOINT mvn spring-boot:run