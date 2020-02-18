package com.yhc.example.zguide.auth.server.util;


import com.alibaba.fastjson.JSONObject;
import com.yhc.example.zguide.common.util.reponse.R;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class ResponseUtil {

    public static void out(HttpServletResponse response, R result) {
        PrintWriter out = null;
        JSONObject gson = new JSONObject();
        try {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json");
            out = response.getWriter();
            out.println(gson.toJSONString(result));
        } catch (Exception e) {
        } finally {
            if (out != null) {
                out.flush();
                out.close();
            }
        }

    }

}
