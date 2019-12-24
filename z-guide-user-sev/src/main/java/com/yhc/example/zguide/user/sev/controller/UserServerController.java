package com.yhc.example.zguide.user.sev.controller;

import com.yhc.example.zguide.common.util.R;
import com.yhc.example.zguide.user.api.mode.UserEntity;
import com.yhc.example.zguide.user.api.server.UserHystrixServer;
import com.yhc.example.zguide.user.sev.server.UserServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RefreshScope
public class UserServerController implements UserHystrixServer {
    @Value("${config.hello}")
    private String hello;

    @Autowired
    private UserServer userServer;
    @RequestMapping(value = "/user/getUser", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    public UserEntity getUser() {
        return userServer.getUser();
    }

    @RequestMapping(value = "/user/test", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    public String test() {
        return hello;
    }

    @RequestMapping(value = "/user/list", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    public R list() {
        Map<String,Object> map = new HashMap<>();
        return R.data(userServer.list(map));
    }
}
