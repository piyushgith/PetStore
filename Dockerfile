#Enable where mvn is not installed
#FROM maven:3.5.2-jdk-8-alpine AS MAVEN_TOOL_CHAIN
#MAINTAINER piyushprasad2007
#RUN mkdir -p /home/app
#WORKDIR /home/app
#COPY . /home/app
#RUN mvn -f /home/app/pom.xml clean package -DskipTests=true

#FROM tomcat:jdk8-openjdk
FROM tomcat:9.0.37-jdk8-openjdk
RUN rm -rf /usr/local/tomcat/webapps/*
COPY ./target/petstore.war /usr/local/tomcat/webapps/petstore.war
#COPY --from=MAVEN_TOOL_CHAIN /home/app/petstore.war /usr/local/tomcat/webapps/petstore.war
WORKDIR /opt/tomcat/webapps
EXPOSE 8080
CMD ["catalina.sh","run"]