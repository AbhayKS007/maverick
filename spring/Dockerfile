FROM openjdk:17
WORKDIR /opt
ENV PORT 8080
EXPOSE 8080
COPY target/*.jar /opt/bank-0.0.1-SNAPSHOT.jar
ENTRYPOINT exec java -jar /opt/bank-0.0.1-SNAPSHOT.jar