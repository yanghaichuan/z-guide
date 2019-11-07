package com.yhc.example.zguide.user.sev.controller;

import com.yhc.example.zguide.user.api.mode.UserEntity;
import com.yhc.example.zguide.user.api.server.UserHystrixServer;
import com.yhc.example.zguide.user.sev.server.UserServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserServerController implements UserHystrixServer {
    @Autowired
    private UserServer userServer;
    @RequestMapping(value = "/user/getUser", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    public UserEntity getUser() {
        return userServer.getUser();
    }
}
