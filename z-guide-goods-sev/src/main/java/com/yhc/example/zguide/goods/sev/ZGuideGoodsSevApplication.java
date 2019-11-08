package com.yhc.example.zguide.goods.sev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableCircuitBreaker
@ComponentScan(basePackages = {"com.yhc.example.zguide.user.api","com.yhc.example.zguide.goods"})
@EnableFeignClients(basePackages = {"com.yhc.example.zguide.user.api.server"})
@EnableDiscoveryClient
public class ZGuideGoodsSevApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZGuideGoodsSevApplication.class, args);
    }

}
