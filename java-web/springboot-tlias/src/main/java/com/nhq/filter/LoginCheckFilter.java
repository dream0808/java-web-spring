package com.nhq.filter;

import com.alibaba.fastjson.JSONObject;
import com.nhq.pojo.Result;
import com.nhq.utils.JwtUtils;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.io.IOException;

/**
 * @author hpy
 * @version 1.0
 * @email 929957466h@gmail.com
 * @date 2023/3/26 21:49
 * @description: TODO
 */
@Slf4j
//@WebFilter(urlPatterns = "/*")
public class LoginCheckFilter implements Filter {
    //初始化方法，只调用一次
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        //1.获取请求url。

        //2.判断请求ur1中是否包含login,如果包含，说明是登录操作，放行。
        String url = request.getRequestURI().toString();
        log.info("请求url：{}",url);

        if(url.contains("login")){
            log.info("登录操作，放行");
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }

        //3.获取请求头中的令牌(token)。
        String token = request.getHeader("token");

        //4.判断令牌是否存在，如果不存在，返回错误结果（未登录）。
        if(!StringUtils.hasLength(token)){
            log.info("未登录");
            Result result = Result.error("NO_LOGIN");
            String jsonString = JSONObject.toJSONString(result);
            response.getWriter().write(jsonString);
            return;
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
            return;
        }

        //6.放行。
        log.info("令牌合法，放行");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    //销毁方法，只调用一次
    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
