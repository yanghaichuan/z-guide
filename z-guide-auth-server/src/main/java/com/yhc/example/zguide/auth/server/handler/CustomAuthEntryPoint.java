package com.yhc.example.zguide.auth.server.handler;

import com.yhc.example.zguide.auth.server.util.ResponseUtil;
import com.yhc.example.zguide.common.util.reponse.R;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CustomAuthEntryPoint implements AuthenticationEntryPoint {
    /**
     * 自定义EntryPoint用于tokan校验失败返回信息
     *
     * @param request
     * @param response
     * @param e
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        //返回json形式的错误信息
        ResponseUtil.out(response, R.error("token校验失败"));
    }
}
