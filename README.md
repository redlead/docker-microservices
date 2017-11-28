# Microservices with Docker and Spring Boot demo

This project consists of 4 modules

- Discovery service (`service-system-eureka`)
- Api Gateway service (`service-system-api-gateway`)
- Client service (`service-client`)
- Product service (`service-product`)

Business logic is simple: there are some clients, every client has some products.
You can run microservices and try next endpoints:

````
curl http://localhost:8080/api/service-product/product/1

{
  "id": 1,
  "name": "product name",
  "description": "product description"
}
````

````
curl http://localhost:8080/api/service-client/client/1

{
  "id": 1,
  "description": "Zaphod Biblebrox",
  "name": "Zaphod"
}
````

````
curl http://localhost:8082/api/service-client/client/1/full

{
  "id": 1,
  "products": [
    {
      "id": 1,
      "name": "product name",
      "description": "product description"
    },
    {
      "id": 2,
      "name": "product name",
      "description": "product description"
    }
  ],
  "description": "Zaphod Biblebrox",
  "name": "Zaphod"
}
````

Discovery service UI can be accesed at `http://localhost:8761`.

## How to build
You have to have Docker installed.
````
mvn clean package
docker-compose build
````

## Run without docker
````
java -jar service-system-eureka/target/service-system-eureka-1.0-SNAPSHOT.jar
java -jar service-system-eureka/target/service-system-api-gateway-1.0-SNAPSHOT.jar
java -jar -Dserver.port=8081 service-product/target/service-product-1.0-SNAPSHOT.jar
java -jar -Dserver.port=8082 service-client/target/service-client-1.0-SNAPSHOT.jar
````

## Run with docker
````
docker network rm spring-cloud-network
docker network create spring-cloud-network
docker run -d --net=spring-cloud-network --name service-system-eureka -e "SPRING_PROFILES_ACTIVE=dev" -p 8761:8761 -t redlead/service-system-eureka
docker run -d --net=spring-cloud-network --name service-product -e "SPRING_PROFILES_ACTIVE=dev" -e "EUREKA_URI=http://service-system-eureka:8761/eureka" -p 8080:8080 -t redlead/service-system-api-gateway
docker run -d --net=spring-cloud-network --name service-product -e "SPRING_PROFILES_ACTIVE=dev" -e "EUREKA_URI=http://service-system-eureka:8761/eureka" -t redlead/service-product
docker run -d --net=spring-cloud-network --name service-client -e "SPRING_PROFILES_ACTIVE=dev" -e "EUREKA_URI=http://service-system-eureka:8761/eureka" -t redlead/service-client
````

## Run with docker-compose
````
docker-compose up -d
````

## Useful commands
````
docker stop $(docker ps -a -q)
docker rm $(docker ps -a -q)
docker rmi $(docker images -q -f dangling=true)
docker-compose down
````