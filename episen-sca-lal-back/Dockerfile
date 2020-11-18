FROM maven:3.5.4-jdk-8-alpine As builder

COPY ./pom.xml ./pom.xml
COPY ./src ./src

RUN mvn package


FROM openjdk:8-alpine

COPY --from=builder ./target/*.jar ./app.jar
COPY ./data/orders.txt ./data/orders.txt

RUN addgroup -S appgroup && adduser -S appuser -G appgroup
RUN chown -R appuser /data/

USER appuser

EXPOSE 8080:8080

ENTRYPOINT ["java","-jar","app.jar"]

LABEL multi.version="1.0" multi.description="Spring Boot Backend App" multi.maintainer="lalves1410"
LABEL exposed-url="http://localhost:8080"
