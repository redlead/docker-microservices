= Microservices with docker demo


Run as without docker

java -jar service-system-eureka/target/service-system-eureka-1.0-SNAPSHOT.jar
java -jar -Dserver.port=8081 service-product/target/service-product-1.0-SNAPSHOT.jar
java -jar -Dserver.port=8082 service-client/target/service-client-1.0-SNAPSHOT.jar

visit

http://localhost:8671

try

curl http://localhost:8081/product/1
curl http://localhost:8082/client/1
curl http://localhost:8082/client/1/full