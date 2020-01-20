package com.yhc.example.zguide.user.sev.server;

import com.yhc.example.zguide.user.api.mode.UserEntity;

import java.util.List;
import java.util.Map;

public interface UserServer {
    List<UserEntity> list(Map<String,Object> params);

    UserEntity get(Integer id);

    UserEntity getUser();

    boolean update(UserEntity user);
}
