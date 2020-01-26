package com.yhc.example.zguide.user.api.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserRequestDto implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 登录名
     */
    private String loginName;

    /**
     * 密码
     */
    private String password;
}
