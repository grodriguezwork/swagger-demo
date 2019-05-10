FROM alpine:3.3
RUN apk --update add openjdk8-jre
ADD /target/gaboninja-0.0.1-SNAPSHOT.jar appMs.jar
EXPOSE 8094
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/appMs.jar"]
