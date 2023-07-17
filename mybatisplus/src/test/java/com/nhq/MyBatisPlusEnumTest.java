package com.nhq;

import com.nhq.enums.SexEnum;
import com.nhq.mapper.UserMapper;
import com.nhq.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author hpy
 * @version 1.0
 * @email 929957466h@gmail.com
 * @date 2023/3/26 21:49
 * @description: TODO
 */
@SpringBootTest
public class MyBatisPlusEnumTest {


    @Autowired
    private UserMapper userMapper;

    @Test
    public void test(){

        User user = new User();
        user.setName("张一山");
        user.setPassword("zzzz");
        user.setSex(SexEnum.MALE);

        int row = userMapper.insert(user);

        System.out.println(row);

    }
}
