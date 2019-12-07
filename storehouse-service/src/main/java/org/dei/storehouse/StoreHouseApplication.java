package org.dei.storehouse;

import org.dei.storehouse.configurations.RabbitConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
@Import(RabbitConfiguration.class)
public class StoreHouseApplication {
    public static void main(String[] args) {
        SpringApplication.run(StoreHouseApplication.class, args);
    }
}
