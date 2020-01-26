package com.yhc.example.zguide.user.sev.dao;

import com.yhc.example.zguide.user.api.mode.UserEntity;

import java.util.List;
import java.util.Map;

public interface UserDaoMapper {
    List<UserEntity> list(Map<String,Object> params);

    UserEntity get(Integer id);

    int update(UserEntity user);

    int save(UserEntity user);
}
