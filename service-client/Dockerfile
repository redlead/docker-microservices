FROM java:8-jdk-alpine
VOLUME /tmp
ADD target/service-*.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]