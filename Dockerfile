FROM maven:3.5.2-jdk-8-alpine AS MAVEN_TOOL_CHAIN
COPY pom.xml /tmp/
COPY src /tmp/src/
WORKDIR /tmp/
RUN mvn clean package -DskipTests=true
#mvn clean install -DskipTests=true

#FROM tomcat:jdk8-openjdk
FROM tomcat:9.0.30-jdk8-openjdk
RUN rm -rf /usr/local/tomcat/webapps/*
COPY ./target/petstore.war /usr/local/tomcat/webapps/petstore.war
CMD ["catalina.sh","run"]