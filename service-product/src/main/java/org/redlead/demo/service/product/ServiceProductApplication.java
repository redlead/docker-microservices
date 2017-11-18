package org.redlead.demo.service.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ServiceProductApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(ServiceProductApplication.class, args);
    }

}
