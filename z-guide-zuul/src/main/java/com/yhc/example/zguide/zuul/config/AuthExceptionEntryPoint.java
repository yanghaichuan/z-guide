package com.yhc.example.zguide.zuul.config;

import com.alibaba.fastjson.JSONObject;
import com.yhc.example.zguide.common.util.Constant.MsgConstant;
import com.yhc.example.zguide.common.util.reponse.R;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@Component
public class AuthExceptionEntryPoint implements AuthenticationEntryPoint
{

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException){
        Throwable cause = authException.getCause();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code",500);
        jsonObject.put("msg", MsgConstant.MSG_ERROR_TOKEN);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        PrintWriter out = null;
        try {
            if(cause == null){
                jsonObject.put("code",500);
                jsonObject.put("msg", MsgConstant.MSG_ERROR_EMPTY_TOKEN);
                out = response.getWriter();
                out.append(jsonObject.toString());
            }else if(cause instanceof InvalidTokenException) {
                out = response.getWriter();
                out.append(jsonObject.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }
}

