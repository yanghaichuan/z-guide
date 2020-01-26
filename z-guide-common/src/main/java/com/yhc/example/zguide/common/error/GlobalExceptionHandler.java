package com.yhc.example.zguide.common.error;

import com.alibaba.fastjson.JSONObject;
import com.yhc.example.zguide.common.util.reponse.R;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public R processDefaultException(HttpServletResponse response,
                                               Exception e) {
        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        response.setContentType("application/json;charset=UTF-8");
//        result.setCode(ApiResultStatus.INTERNAL_SERVER_ERROR.getApiResultStatus());
//        result.setMessage(messageSource.getMessage(ApiResultStatus.INTERNAL_SERVER_ERROR.getMessageResourceName(), null,
//                LocaleContextHolder.getLocale()));
        return R.error(JSONObject.toJSONString(e));
    }
}
