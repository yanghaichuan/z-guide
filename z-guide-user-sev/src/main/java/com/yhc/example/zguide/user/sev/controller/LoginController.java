package com.yhc.example.zguide.user.sev.controller;

import com.yhc.example.zguide.common.util.reponse.R;
import com.yhc.example.zguide.user.api.dto.UserRequestDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
public class LoginController {
    /**
     * 登录
     * @param userRequestDto
     * @return
     */
    @PostMapping("/login")
    public R list(@RequestBody UserRequestDto userRequestDto) {
        return R.ok();
    }
}
