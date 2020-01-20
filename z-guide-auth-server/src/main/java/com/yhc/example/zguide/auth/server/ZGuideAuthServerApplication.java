package com.yhc.example.zguide.auth.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.yhc.example.zguide.auth.server.user.dao")
public class ZGuideAuthServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZGuideAuthServerApplication.class, args);
    }

}
