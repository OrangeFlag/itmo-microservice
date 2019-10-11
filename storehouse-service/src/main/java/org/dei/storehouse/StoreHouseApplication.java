package org.dei.storehouse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class StoreHouseApplication {
    public static void main(String[] args) {
        SpringApplication.run(StoreHouseApplication.class, args);
    }
}
