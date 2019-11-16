package com.yhc.example.zguide.config.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppConfigController {
   @Value("${spring.application.name}")
    private String applicationName;
    @Value("${server.port}")
    private String port;

    @RequestMapping(value = "/config/test")
    public String test(){
        return "66666===="+applicationName+":"+port;
    }
}
