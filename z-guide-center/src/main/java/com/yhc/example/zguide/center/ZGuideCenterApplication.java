package com.yhc.example.zguide.center;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ZGuideCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZGuideCenterApplication.class, args);
    }

}
