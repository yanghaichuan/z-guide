package com.yhc.example.zguide.user.sev.server.impl;

import com.yhc.example.zguide.user.api.mode.UserEntity;
import com.yhc.example.zguide.user.sev.server.UserServer;
import org.springframework.stereotype.Service;

@Service("UserServer")
public class UserServerImpl implements UserServer {
    @Override
    public UserEntity getUser() {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(1l);
        userEntity.setRealName("邓杰");
        userEntity.setLoginName("dj2019");
        return userEntity;
    }
}
