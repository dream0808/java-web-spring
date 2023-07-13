package com.nhq.springdemo.controller;

import com.nhq.springdemo.pojo.Address;
import com.nhq.springdemo.pojo.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hpy
 * @version 1.0
 * @email 929957466h@gmail.com
 * @date 2023/3/26 21:49
 * @description: TODO
 */
@RestController
public class ResponseController {


    @RequestMapping("/hello")
    public Result hello(){
        System.out.println("hello world");
        //return new Result(1,"success","hello world");
        return Result.success("hello world");
    }

    @RequestMapping("/getAddr")
    public Result getAddr(){
        Address address = new Address();
        address.setCity("东莞");
        address.setProvince("广东");

        return Result.success(address);
    }

}
