package com.yhc.example.zguide.auth.server.user.server.impl;

import com.yhc.example.zguide.auth.server.user.dao.UserAuthDaoMapper;
import com.yhc.example.zguide.auth.server.user.modle.UserAuthEntity;
import com.yhc.example.zguide.auth.server.user.server.UserAuthServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userAuthServer")
public class UserAuthServerImpl implements UserAuthServer {
    @Autowired
    private UserAuthDaoMapper userAuthDaoMapper;
    @Override
    public UserAuthEntity getUser(String loginName) {
        return userAuthDaoMapper.getUser(loginName);
    }
}
