package com.yhc.example.zguide.user.sev.controller;

import com.yhc.example.zguide.common.util.R;
import com.yhc.example.zguide.user.api.mode.AreaEntity;
import com.yhc.example.zguide.user.api.mode.UserEntity;
import com.yhc.example.zguide.user.api.server.UserHystrixServer;
import com.yhc.example.zguide.user.sev.server.AreaServer;
import com.yhc.example.zguide.user.sev.server.UserServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RefreshScope
public class UserServerController implements UserHystrixServer {
    @Value("${config.hello}")
    private String hello;

    @Autowired
    private UserServer userServer;

    @Autowired
    private AreaServer areaServer;

    @RequestMapping(value = "/user/getUser", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    public UserEntity getUser() {
        return userServer.getUser();
    }

    @Override
    public R updateUser(@RequestBody UserEntity user) {
        boolean flag = userServer.update(user);
        if(!flag){
            return R.error();
        }
        return  R.ok();
    }

    @RequestMapping(value = "/user/test", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    public String test() {
        return hello;
    }

    @RequestMapping(value = "/user/list", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    public R list() {
        Map<String, Object> map = new HashMap<>();
        return R.data(userServer.list(map));
    }

    @RequestMapping(value = "/area/list", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    public R areaList() {
        long startTime=System.currentTimeMillis(); //获取开始时间
        List<AreaEntity> list = areaServer.list();
        long endTime=System.currentTimeMillis(); //获取结束时间
        System.out.println("程序运行时间："+(endTime-startTime)+"ms");
        return R.data(list);
    }

    @RequestMapping(value = "/area/save", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
    public R saveArea(@RequestBody AreaEntity area) {
       boolean flag = areaServer.saveArea(area);
        if(flag){
            R.ok();
        }
        return R.error();
    }
}
