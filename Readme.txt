sudo docker container run -p 3306:3306 --name mysqldb -e MYSQL_ROOT_PASSWORD=piyush -e MYSQL_DATABASE=test1 -d mysql:5.7.29

#search container ip address by name
sudo docker inspect -f '{{.Name}} - {{range .NetworkSettings.Networks}}{{.IPAddress}}{{end}}' mysqldb

update localhost in application.properties

#sudo docker container exec -it a49083 bash

#mysql -u root -p

#in project folder

mvn clean package -e

sudo docker image build -t petstore .
//ignore below port but needed 
sudo docker container run -d -p 2000:2000 --name petstore petstore:latest


http://localhost:8080/petstore/hi

from docker
url format: IPAddress+tomcat_port+warfilename+path
http://172.17.0.4:8080/petstore/getPets