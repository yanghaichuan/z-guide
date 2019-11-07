package com.yhc.example.zguide.user.sev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ZGuideUserSevApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZGuideUserSevApplication.class, args);
    }

}
