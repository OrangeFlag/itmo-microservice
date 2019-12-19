package org.dei.storehouse.configurations;

import feign.Request;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfiguration {

    //public static final int connectTimeOutMillis = 10;
    // public static final int readTimeOutMillis = 10;

    public static final int connectTimeOutMillis = 12000;
    public static final int readTimeOutMillis = 12000;

    @Bean
    public Request.Options options() {
        return new Request.Options(connectTimeOutMillis, readTimeOutMillis);
    }
}
