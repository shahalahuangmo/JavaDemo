package com.example.demo.common.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.common.dto.output.ApiResult;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 使用Response 输出json
 */
@Slf4j
public class ResponseUtils {
    /**
     * 输出响应结果
     * @param response
     * @param result
     */
    public static void out(ServletResponse response, ApiResult result) {
        PrintWriter out = null;
        try {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json");
            out = response.getWriter();
            out.println(JSON.toJSONString(result));
        } catch (Exception e) {
            log.error(e + "输出JSON出错");
        } finally {
            if (out != null) {
                out.flush();
                out.close();
            }
        }
    }

    /**
     * 获取响应内容
     *
     * @param httpServletResponse
     * @param msg
     * @param status
     */
    public static void getResponse(HttpServletResponse httpServletResponse, String msg, Integer status) {
        PrintWriter writer = null;
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType("application/json; charset=utf-8");
        try {
            writer = httpServletResponse.getWriter();
            writer.print(JSONObject.toJSONString(new ApiResult(status, msg, null)));
        } catch (IOException e) {
            log.error("响应报错", e.getMessage());
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }
}
