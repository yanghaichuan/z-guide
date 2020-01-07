package com.yhc.example.zguide.user.sev.server.impl;

import com.yhc.example.zguide.user.api.mode.UserEntity;
import com.yhc.example.zguide.user.sev.dao.UserDaoMapper;
import com.yhc.example.zguide.user.sev.server.UserServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("UserServer")
public class UserServerImpl implements UserServer {
    @Autowired
    private UserDaoMapper userDaoMapper;

    @Override
    public List<UserEntity> list(Map<String, Object> params) {
        return userDaoMapper.list(params);
    }

    @Override
    public UserEntity get(Integer id) {
        return userDaoMapper.get(id);
    }

    @Override
    public UserEntity getUser() {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(1l);
        userEntity.setRealName("邓杰");
        userEntity.setLoginName("dj2019");
        return userEntity;
    }

    @Override
    public boolean update(UserEntity user) {
        boolean flag = false;
        int i = userDaoMapper.update(user);
        if(i>0){
            flag = true;
        }
        return flag;
    }
}
