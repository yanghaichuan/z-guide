package com.yhc.example.zguide.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class ZGuideZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZGuideZuulApplication.class, args);
    }

}
