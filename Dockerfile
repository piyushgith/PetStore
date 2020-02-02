#FROM tomcat:jdk8-openjdk
FROM tomcat:9.0.30-jdk8-openjdk
RUN rm -rf /usr/local/tomcat/webapps/*
COPY ./target/petstore.war /usr/local/tomcat/webapps/petstore.war
CMD ["catalina.sh","run"]