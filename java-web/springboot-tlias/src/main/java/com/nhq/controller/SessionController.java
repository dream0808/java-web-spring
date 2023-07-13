package com.nhq.controller;

import com.nhq.pojo.Result;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hpy
 * @version 1.0
 * @email 929957466h@gmail.com
 * @date 2023/3/26 21:49
 * @description: TODO
 */
@RestController
public class SessionController {


    @GetMapping("/c1")
    public Result cookie1(HttpServletResponse response){
        response.addCookie(new Cookie("login_name","test"));

        return Result.success();
    }


    @GetMapping("/c2")
    public Result cookie2(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        String result = null;
        for (Cookie cookie : cookies) {
            if(cookie.getName().equals("login_name")){
                System.out.println("login_name:"+cookie.getValue());
                result = cookie.getValue();
            }
        }
        return Result.success(result);
    }
}
