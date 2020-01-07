package com.yhc.example.zguide.auth.server.user.dao;

import com.yhc.example.zguide.auth.server.user.modle.UserAuthEntity;

public interface UserAuthDaoMapper {
    UserAuthEntity getUser(String loginName);
}
