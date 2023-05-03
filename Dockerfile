FROM amazoncorretto:8
MAINTAINER sanf
COPY target/sandrafabrizi-0.0.1-SNAPSHOT.jar portfoliosf-app.jar
ENTRYPOINT ["java","-jar","/portfoliosf-app.jar"]
EXPOSE 8080
