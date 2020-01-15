package com.yhc.example.zguide.auth.server.controller;

import com.yhc.example.zguide.auth.server.redis.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
public class RedisTestController {
    @Autowired
    RedisUtil redisUtil;
    @RequestMapping(value = "/api/test", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    public String test(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHssmm");
        String key = "k"+sdf.format(new Date());
        redisUtil.set(key,"123456");
        System.out.print("key======================================================="+key);
        return  key;
    }

    @RequestMapping(value = "/api/get", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    public String get(@RequestParam String key){
        Object value = redisUtil.get(key);
        System.out.print("value======================================================="+value);
        return  value.toString();
    }

    @RequestMapping(value = "/test/get", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    public String test(@RequestParam String key){
        Object value = redisUtil.get(key);
        System.out.print("value======================================================="+value);
        return  value.toString();
    }

    @RequestMapping(value = "/test/pwd", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    public String pwd(@RequestParam String pwd){
        String pwdCode = new BCryptPasswordEncoder().encode(pwd);
        System.out.print("value======================================================="+pwdCode);
        return pwdCode;
    }
    @RequestMapping("/user")
    public Principal user(Principal user) {
        return user;
    }
}
