FROM amazoncorretto:8
MAINTAINER sanf
COPY target/sandrafabrizi-0.0.1-SNAPSHOT.jar backsf.jar
ENTRYPOINT ["java","-jar","/backsf.jar"]
EXPOSE 8080