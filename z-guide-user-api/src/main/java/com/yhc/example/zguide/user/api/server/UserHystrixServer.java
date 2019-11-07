package com.yhc.example.zguide.user.api.server;

import com.yhc.example.zguide.user.api.mode.UserEntity;
import com.yhc.example.zguide.user.api.fallback.UserServerFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "guide-user" ,fallback = UserServerFallback.class)
public interface UserHystrixServer {
    @RequestMapping(value = "/user/getUser",method = RequestMethod.GET)
    public UserEntity getUser();
}
