package com.yhc.example.zguide.user.api.server;

import com.yhc.example.zguide.common.util.R;
import com.yhc.example.zguide.user.api.mode.AreaEntity;
import com.yhc.example.zguide.user.api.mode.UserEntity;
import com.yhc.example.zguide.user.api.fallback.UserServerFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "guide-user" ,fallback = UserServerFallback.class)
public interface UserHystrixServer {
    @RequestMapping(value = "/user/getUser",method = RequestMethod.GET)
    public UserEntity getUser();

    @RequestMapping(value = "/user/updateUser",method = RequestMethod.POST)
    public R updateUser(@RequestBody UserEntity user);

    @RequestMapping(value = "/area/list", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    public R areaList();
}
