FROM amazoncorretto:8-alpine-jdk
MAINTAINER sanf
COPY target/sandrafabrizi-0.0.1-SNAPSHOT.jar backportfolio-app.jar
ENTRYPOINT ["java","-jar","/backportfolio-app.jar"]
EXPOSE 8080
