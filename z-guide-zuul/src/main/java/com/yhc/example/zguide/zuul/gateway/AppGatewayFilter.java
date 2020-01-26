package com.yhc.example.zguide.zuul.gateway;

import com.alibaba.fastjson.JSONObject;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import javax.servlet.http.HttpServletRequest;

@Component
public class AppGatewayFilter extends ZuulFilter {
    private static Logger log = LoggerFactory.getLogger(AppGatewayFilter.class);
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run(){
        try {
            RequestContext context = RequestContext.getCurrentContext();
            HttpServletRequest request = context.getRequest();
            log.info("请求接口地址:"+request.getRequestURI());
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("method",request.getMethod());
            jsonObject.put("contextPath",request.getContextPath());
            jsonObject.put("url",request.getRequestURI());
        } catch (Exception var5) {
            ReflectionUtils.rethrowRuntimeException(var5);
        }

        return null;
    }
}

