package com.yhc.example.zguide.auth.server.user.server;

import com.yhc.example.zguide.auth.server.user.modle.UserAuthEntity;

public interface UserAuthServer {
    UserAuthEntity getUser(String loginName);
}
