package com.yhc.example.zguide.auth.server.user.dao;

import com.yhc.example.zguide.auth.server.user.modle.UserAuthEntity;

import java.util.Map;

public interface UserAuthDaoMapper {
    UserAuthEntity getUser(Map<String,Object> params);
}
