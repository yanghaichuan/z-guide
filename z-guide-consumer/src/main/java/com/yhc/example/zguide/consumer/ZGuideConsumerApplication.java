package com.yhc.example.zguide.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableCircuitBreaker
@ComponentScan(basePackages = {"com.yhc.example.zguide.user.api","com.yhc.example.zguide.consumer"})
@EnableFeignClients(basePackages = {"com.yhc.example.zguide.user.api.server"})
public class ZGuideConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZGuideConsumerApplication.class, args);
    }

}
