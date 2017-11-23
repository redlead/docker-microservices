package org.redlead.demo.service.system.api.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class ServiceSystemApiGatewayApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(ServiceSystemApiGatewayApplication.class, args);
    }

}
