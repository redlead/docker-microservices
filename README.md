= Microservices with docker demo


Run as without docker

java -jar service-system-eureka/target/service-system-eureka-1.0-SNAPSHOT.jar
java -jar -Dserver.port=8081 service-product/target/service-product-1.0-SNAPSHOT.jar
java -jar -Dserver.port=8082 service-client/target/service-client-1.0-SNAPSHOT.jar

visit

http://localhost:8761

try

curl http://localhost:8081/product/1
curl http://localhost:8082/client/1
curl http://localhost:8082/client/1/full

Run with docker

docker run -d -e "SPRING_PROFILES_ACTIVE=dev" -p 8761:8761 -t redlead/service-system-eureka
docker run -d -e "SPRING_PROFILES_ACTIVE=dev" -e "EUREKA_URI=http://localhost:8761/eureka" -p 8081:8080 -t redlead/service-product


docker stop $(docker ps -a -q)
docker rm $(docker ps -a -q)