package com.nhq;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.nhq.mapper.UserMapper;
import com.nhq.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

/**
 * @author hpy
 * @version 1.0
 * @email 929957466h@gmail.com
 * @date 2023/3/26 21:49
 * @description: TODO
 */
@SpringBootTest
public class MyBatisPlusWrapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test01(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name","黄")
                    .isNotNull("password");

        List<User> list = userMapper.selectList(queryWrapper);

        list.forEach(System.out::println);
    }

    @Test
    public void test02(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("id")
                .orderByDesc("name");
        List<User> list = userMapper.selectList(queryWrapper);

        list.forEach(System.out::println);
    }
    @Test
    public void test03(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id","215580682");

        int row = userMapper.delete(queryWrapper);

        System.out.println(row);
    }

    @Test
    public void test04(){
        User user = new User();
        user.setName("黄梓涵11");
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",215580681);


        int row = userMapper.update(user, queryWrapper);

        System.out.println(row);
    }

    @Test
    public void test05(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("name","password");

        List<Map<String, Object>> maps =
                userMapper.selectMaps(queryWrapper);

        maps.forEach(System.out::println);

    }

    @Test
    public void test06(){
        UpdateWrapper<User> userUpdateWrapper = new UpdateWrapper<User>();

        userUpdateWrapper.eq("id","215580682");

        userUpdateWrapper.set("name","卢本伟")
                .set("password","666666");

        int row = userMapper.update(null, userUpdateWrapper);

        System.out.println(row);


    }

    @Test
    public void test07(){
        String name = "黄";
        String password = "";

        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();

        queryWrapper.like(StringUtils.isNotBlank(name),"name",name);
        queryWrapper.eq(StringUtils.isNotBlank(password),"password",password);

        List<Map<String, Object>> maps = userMapper.selectMaps(queryWrapper);

        maps.forEach(System.out::println);
    }

    @Test
    public void test08(){
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        String name = "";
        lambdaQueryWrapper.like(StringUtils.isNotBlank(name),User::getName,name);

        List<User> users = userMapper.selectList(lambdaQueryWrapper);

        users.forEach(System.out::println);

    }

    @Test
    public void test09(){
        LambdaUpdateWrapper<User> lambdaQueryWrapper = new LambdaUpdateWrapper<>();
        String name = "cxk";
        lambdaQueryWrapper.eq(StringUtils.isNotBlank(name),User::getName,name);

        lambdaQueryWrapper.set(User::getName,"蔡徐坤").set(User::getPassword,"ikun");

        int row = userMapper.update(null, lambdaQueryWrapper);

        System.out.println(row);


    }


}
