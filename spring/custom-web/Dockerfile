FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} web-customer.jar
ENTRYPOINT ["java","-jar","/web-customer.jar"]