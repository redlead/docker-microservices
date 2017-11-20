# Microservices with Docker and Spring Boot demo

This project consists of 3 modules

- Discovery service (`service-system-eureka`)
- Client service (`service-client`)
- Product service (`service-product`)

Business logic is simple: there are some clients, every client has some products.
You can run microservices and try next endpoints:

````
curl http://localhost:8081/product/1

{
  "id": 1,
  "name": "product name",
  "description": "product description"
}
````

````
curl http://localhost:8082/client/1

{
  "id": 1,
  "description": "Zaphod Biblebrox",
  "name": "Zaphod"
}
````

````
curl http://localhost:8082/client/1/full

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
You have to have Docker installed. Run `mvn clean package install`.

## Run without docker
````
java -jar service-system-eureka/target/service-system-eureka-1.0-SNAPSHOT.jar
java -jar -Dserver.port=8081 service-product/target/service-product-1.0-SNAPSHOT.jar
java -jar -Dserver.port=8082 service-client/target/service-client-1.0-SNAPSHOT.jar
````

## Run with docker
````
docker network rm demo
docker network create demo
docker run -d --net=demo --name service-system-eureka -e "SPRING_PROFILES_ACTIVE=dev" -p 8761:8761 -t redlead/service-system-eureka
docker run -d --net=demo --name service-product -e "SPRING_PROFILES_ACTIVE=dev" -e "EUREKA_URI=http://service-system-eureka:8761/eureka" -p 8081:8080 -t redlead/service-product
docker run -d --net=demo --name service-client -e "SPRING_PROFILES_ACTIVE=dev" -e "EUREKA_URI=http://service-system-eureka:8761/eureka" -p 8082:8080 -t redlead/service-client
````

## Useful commands
````
docker stop $(docker ps -a -q)
docker rm $(docker ps -a -q)
docker rmi $(docker images -q -f dangling=true)
````