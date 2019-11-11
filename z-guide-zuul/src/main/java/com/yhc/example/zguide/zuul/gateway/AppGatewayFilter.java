package com.yhc.example.zguide.zuul.gateway;

import com.alibaba.fastjson.JSONObject;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.util.ZuulRuntimeException;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

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
    public Object run() throws ZuulException {
        try {
            RequestContext context = RequestContext.getCurrentContext();
            HttpServletRequest request = context.getRequest();
            log.info("请求接口地址:"+request.getRequestURI());
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("method",request.getMethod());
            jsonObject.put("contextPath",request.getContextPath());
            jsonObject.put("url",request.getRequestURI());

//            RequestContext context = RequestContext.getCurrentContext();
//            ZuulException exception = this.findZuulException(context.getThrowable());
//            log.error("进入系统异常拦截", exception);
//
//            HttpServletResponse response = context.getResponse();
//            response.setContentType("application/json; charset=utf8");
//            response.setStatus(exception.nStatusCode);
//            PrintWriter writer = null;
//            try {
//                writer = response.getWriter();
//                writer.print("{code:"+ exception.nStatusCode +",message:\""+ exception.getMessage() +"\"}");
//            } catch (IOException e) {
//                e.printStackTrace();
//            } finally {
//                if(writer!=null){
//                    writer.close();
//                }
//            }

        } catch (Exception var5) {
            ReflectionUtils.rethrowRuntimeException(var5);
        }

        return null;
    }

//    ZuulException findZuulException(Throwable throwable) {
//        if (ZuulRuntimeException.class.isInstance(throwable.getCause())) {
//            return (ZuulException)throwable.getCause().getCause();
//        } else if (ZuulException.class.isInstance(throwable.getCause())) {
//            return (ZuulException)throwable.getCause();
//        } else {
//            return ZuulException.class.isInstance(throwable) ? (ZuulException)throwable : new ZuulException(throwable, 500, (String)null);
//        }
//    }
}

