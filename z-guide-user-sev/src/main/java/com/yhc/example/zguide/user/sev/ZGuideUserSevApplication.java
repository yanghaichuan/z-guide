package com.yhc.example.zguide.user.sev;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = "com.yhc.example.zguide.user.sev.dao")
@EnableCaching
public class ZGuideUserSevApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZGuideUserSevApplication.class, args);
    }

}
