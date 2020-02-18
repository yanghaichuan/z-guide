package com.yhc.example.zguide.auth.server.controller;

import com.yhc.example.zguide.auth.server.server.BaseUserDetailService;
import com.yhc.example.zguide.auth.server.server.SysUser;
import com.yhc.example.zguide.auth.server.util.SecurityUtils;
import com.yhc.example.zguide.common.util.reponse.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.security.Principal;
import java.util.*;

@RestController
public class OAuthController {
    @Resource
    @Qualifier("redisTokenStore")
    private TokenStore tokenStore;

    @Autowired
    BaseUserDetailService baseUserDetailService;

    @GetMapping("/user")
    public Principal user(Principal user) {
        return user;
    }
    @RequestMapping("/oauth/remove_token")
    public R removeToken(@RequestParam("token") String token) {
        if (token != null) {
            OAuth2AccessToken accessToken = tokenStore.readAccessToken(token);
            tokenStore.removeAccessToken(accessToken);
        } else {
            return R.error();
        }
        return R.ok();
    }

    @RequestMapping("/oauth/getUser")
    public SysUser getUser() {
        return SecurityUtils.getUser();
    }

    @PostMapping(value = "/oauth/login")
    public R login(@RequestBody Map<String, Object> params) {
        if (params.get("loginName") == null | params.get("password") == null) {
            return R.error("账号或者密码为空");
        }
        return R.ok("登录成功");
    }
}
