package com.yhc.example.zguide.user.api.fallback;

import com.yhc.example.zguide.common.util.reponse.R;
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

    @Override
    public R updateUser(UserEntity user) {
        return R.error("修改用户失败");
    }

    @Override
    public R areaList() {
        return R.error("获取基础数据区域失败");
    }
}
