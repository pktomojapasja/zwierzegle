FROM openjdk:17-jdk-slim

COPY /backend/target/*.jar /app/zwierzegle.jar

EXPOSE 8080

WORKDIR /app

ARG PROFILE
ENV PROFILE ${PROFILE:-production}

CMD exec java -Dspring.profiles.active=$PROFILE -jar /app/zwierzegle.jar 2>&1
