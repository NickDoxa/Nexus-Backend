FROM amazoncorretto:17-alpine-jdk
ARG JAR_FILE=target/nexus-backend-1.0.jar
COPY ${JAR_FILE} nexus-backend-1.0.jar
ENTRYPOINT ["java","-jar","/nexus-backend-1.0.jar"]