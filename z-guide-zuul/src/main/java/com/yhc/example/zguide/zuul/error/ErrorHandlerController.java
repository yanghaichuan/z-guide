package com.yhc.example.zguide.zuul.error;

import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.yhc.example.zguide.common.util.R;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class ErrorHandlerController implements ErrorController {
    /**
     * 出异常后进入该方法，交由下面的方法处理
     */
    @Override
    public String getErrorPath() {
        return "/error";
    }

    @RequestMapping("/error")
    public Object error(HttpServletRequest request, HttpServletResponse response){
//        RequestContext ctx = RequestContext.getCurrentContext();
//        ZuulException exception = (ZuulException)ctx.getThrowable();
//        return R.error(exception.nStatusCode, exception.getMessage());
        Integer status = (Integer)request.getAttribute("javax.servlet.error.status_code");
        return R.error(status, status == 404 ? "访问地址不存在" : "内部服务器错误,正在处理");
    }
}
