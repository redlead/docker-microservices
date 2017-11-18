package org.redlead.demo.service.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ServiceClientApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(ServiceClientApplication.class, args);
    }

}
