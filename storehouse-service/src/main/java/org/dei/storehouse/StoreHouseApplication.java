package org.dei.storehouse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@ImportAutoConfiguration
public class StoreHouseApplication {
    public static void main(String[] args) {
        SpringApplication.run(StoreHouseApplication.class, args);
    }
}
