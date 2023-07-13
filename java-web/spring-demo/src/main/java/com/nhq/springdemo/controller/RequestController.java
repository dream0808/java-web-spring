package com.nhq.springdemo.controller;

import com.nhq.springdemo.pojo.User;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/**
 * @author hpy
 * @version 1.0
 * @email 929957466h@gmail.com
 * @date 2023/3/26 21:49
 * @description: TODO
 */

@RestController
public class RequestController {

    @RequestMapping("/simpleParam")
    public  String simpleParam(String name,Integer age){


        System.out.println(age + "\n" + name);

        return "OK";
    }


    @RequestMapping("/simplePojo")
    public String simplePojo(User user){
        System.out.println(user);

        return "OK";
    }

    @RequestMapping("/complexPojo")
    public String complexPojo(User user){
        System.out.println(user);

        return "OK";
    }

    @RequestMapping("/arrayParam")
    public String arrayParam(String[] hobby){
        System.out.println(Arrays.toString(hobby));

        return "OK";
    }

    @RequestMapping("/listParam")
    public String listParam(@RequestParam List<String> hobby){
        System.out.println(hobby);

        return "OK";
    }

    @RequestMapping("/dateParam")
    public String dateParam(@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime date){
        System.out.println(date);
        return "OK";
    }

    @RequestMapping("/jsonParam")
    public String jsonParam(@RequestBody User user){
        System.out.println(user);
        return "OK";
    }

    @RequestMapping("/path/{id}/{name}")
    public String pathParam(@PathVariable Integer id,@PathVariable String name){
        System.out.println(id);
        System.out.println(name);
        return "OK";
    }
}
