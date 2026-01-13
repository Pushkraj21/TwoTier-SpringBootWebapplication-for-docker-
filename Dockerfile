FROM maven:4.0.0-rc-5-amazoncorretto-25-debian-trixie AS build

WORKDIR /app

COPY pom.xml .

RUN mvn dependency:go-offline -B
 
COPY src ./src

RUN mvn clean package -DskipTests

FROM openjdk:19-ea-jdk-alpine3.16

WORKDIR /aap

COPY --from=build /app/target/*.jar app.jar

CMD ["java", "-jar", "app.jar"]
