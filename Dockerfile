FROM maven:3.5.2-jdk-8-alpine AS MAVEN_TOOL_CHAIN
COPY pom.xml /tmp/
COPY src /tmp/src/

RUN mkdir target
RUN mvn clean package -DskipTests=true
#mvn clean install -DskipTests=true
WORKDIR /tmp/

#FROM tomcat:jdk8-openjdk
FROM tomcat:9.0.37-jdk8-openjdk
RUN rm -rf /usr/local/tomcat/webapps/*
#COPY ./target/petstore.war /usr/local/tomcat/webapps/petstore.war
COPY ./target/petstore.war /temp/petstore.war
CMD ["catalina.sh","run"]
