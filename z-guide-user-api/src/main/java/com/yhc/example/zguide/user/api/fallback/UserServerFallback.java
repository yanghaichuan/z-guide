package com.yhc.example.zguide.user.api.fallback;

import com.yhc.example.zguide.user.api.mode.UserEntity;
import com.yhc.example.zguide.user.api.server.UserHystrixServer;
import org.springframework.stereotype.Component;

@Component
public class UserServerFallback implements UserHystrixServer {
    @Override
    public UserEntity getUser() {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(500l);
        userEntity.setRealName("火星人");

        return userEntity;
    }
}
