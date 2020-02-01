FROM tomcat:jdk8-openjdk
RUN rm -rf /usr/local/tomcat/webapps/*
COPY ./target/petstore-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/myapp.war
CMD ["catalina.sh","run"]