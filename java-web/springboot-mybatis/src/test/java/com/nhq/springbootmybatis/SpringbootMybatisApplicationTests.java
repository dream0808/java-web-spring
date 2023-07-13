package com.nhq.springbootmybatis;

import com.nhq.springbootmybatis.mapper.UserMapper;
import com.nhq.springbootmybatis.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringbootMybatisApplicationTests {

    @Autowired
    private UserMapper userMapper;
    @Test
   public void testListUser(){
        List<User> list = userMapper.list();
        list.stream().forEach(System.out::println);
    }

}
