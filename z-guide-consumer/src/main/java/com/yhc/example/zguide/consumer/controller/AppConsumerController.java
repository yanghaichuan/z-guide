package com.yhc.example.zguide.consumer.controller;

import com.alibaba.fastjson.JSON;
import com.yhc.example.zguide.user.api.mode.UserEntity;
import com.yhc.example.zguide.user.api.server.UserHystrixServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppConsumerController {
    @Autowired
    private UserHystrixServer userHystrixServer;

    @RequestMapping(value = "/app/getUser",method = RequestMethod.GET)
    public String getUser() {
        UserEntity user = userHystrixServer.getUser();
        System.out.print("123456");
        return JSON.toJSONString(user);
    }

}
