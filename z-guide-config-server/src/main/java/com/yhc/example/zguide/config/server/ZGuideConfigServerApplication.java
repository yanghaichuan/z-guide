package com.yhc.example.zguide.config.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ZGuideConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZGuideConfigServerApplication.class, args);
    }

}
