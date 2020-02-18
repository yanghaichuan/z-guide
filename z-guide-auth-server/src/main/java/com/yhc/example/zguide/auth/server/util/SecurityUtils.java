package com.yhc.example.zguide.auth.server.util;


import cn.hutool.core.util.StrUtil;
import com.yhc.example.zguide.auth.server.constant.SecurityConstants;
import com.yhc.example.zguide.auth.server.dto.AuthAccount;
import com.yhc.example.zguide.auth.server.server.SysUser;
import lombok.experimental.UtilityClass;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@UtilityClass
public class SecurityUtils {
    /**
     * 获取Authentication
     */
    public Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    /**
     * 获取用户
     *
     * @param authentication
     * @return SysUser
     * <p>
     * 获取当前用户的全部信息 EnableResourceServer true
     * 获取当前用户的用户名 EnableResourceServer false
     */
    public SysUser getUser(Authentication authentication) {
        Object principal = authentication.getPrincipal();
        if (principal != null) {
            return (SysUser) authentication.getPrincipal();
        }
        return null;
    }

    /**
     * 获取当前用名
     *
     * @return String
     */
    public String getUsername() {
        Object principal = getAuthentication().getPrincipal();
        if (principal instanceof String) {
            return principal.toString();
        }
        return null;
    }


    public String getClientId() {
        Authentication authentication = getAuthentication();
        if (authentication instanceof OAuth2Authentication) {
            OAuth2Authentication auth2Authentication = (OAuth2Authentication) authentication;
            return auth2Authentication.getOAuth2Request().getClientId();
        }
        return null;
    }

    /**
     * 获取用户
     */
    public SysUser getUser() {
        Authentication authentication = getAuthentication();
        if (authentication == null) {
            return null;
        }
        return getUser(authentication);
    }

    /**
     * 获取用户角色信息
     *
     * @return 角色集合
     */
    public List<String> getRoles() {
        Authentication authentication = getAuthentication();
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        List<String> roles = new ArrayList<>();
        authorities.stream()
                .filter(granted -> StrUtil.startWith(granted.getAuthority(), SecurityConstants.ROLE))
                .forEach(granted -> {
                    roles.add(((GrantedAuthority) granted).toString());
                });
        return roles;
    }

}
