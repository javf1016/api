FROM adoptopenjdk/openjdk11:alpine-jre

WORKDIR /app

COPY target/api-0.0.1-SNAPSHOT.jar /app/api-0.0.1-SNAPSHOT.jar
COPY src/main/resources/application.properties /app/application.properties

EXPOSE 8000

CMD ["java", "-jar", "api-0.0.1-SNAPSHOT.jar"]