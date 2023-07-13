package com.nhq.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.nhq.pojo.Result;
import com.nhq.utils.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author hpy
 * @version 1.0
 * @email 929957466h@gmail.com
 * @date 2023/3/26 21:49
 * @description: TODO
 */
@Slf4j
@Component
public class LoginCheckInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //1.获取请求url。

        //2.判断请求ur1中是否包含login,如果包含，说明是登录操作，放行。
        String url = request.getRequestURI().toString();
        log.info("请求url：{}", url);

        if (url.contains("login")) {
            log.info("登录操作，放行");
            return true;
        }

        //3.获取请求头中的令牌(token)。
        String token = request.getHeader("token");

        //4.判断令牌是否存在，如果不存在，返回错误结果（未登录）。
        if (!StringUtils.hasLength(token)) {
            log.info("未登录");
            Result result = Result.error("NO_LOGIN");
            String jsonString = JSONObject.toJSONString(result);
            response.getWriter().write(jsonString);
            return false;
        }

        //5.解析token,如果解析失败，返回错误结果（未登录）。
        try {
            JwtUtils.parseJWT(token);
        } catch (Exception e) {
            //jwt解析失败
            log.info("令牌解析失败");
            Result result = Result.error("NO_LOGIN");
            String jsonString = JSONObject.toJSONString(result);
            response.getWriter().write(jsonString);
            return false;
        }

        //6.放行。
        log.info("令牌合法，放行");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
