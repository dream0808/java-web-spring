package com.nhq;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.nhq.mapper.UserMapper;
import com.nhq.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hpy
 * @version 1.0
 * @email 929957466h@gmail.com
 * @date 2023/3/26 21:49
 * @description TODO
 */
@SpringBootTest
public class MybatisPlusTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelectList(){
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
    }

    @Test
    public void testInsert(){
        User user = new User();
        user.setId(null);
        user.setName("黄梓涵");
        user.setPassword("114514");

        int row = userMapper.insert(user);

        System.out.println(row);

    }

    @Test
    public void testDeleteById(){
//        int row = userMapper.deleteById(215580673);
//        System.out.println(row);

        Map<String,Object> map = new HashMap<>();
        map.put("name","蔡徐坤");
        map.put("password","112233");

        int row = userMapper.deleteByMap(map);
        System.out.println(row);

    }

    @Test
    public void testUpdate(){
        User user = new User();
        user.setId(5);
        user.setName("梁鹏");
        user.setPassword("123456");

        int row = userMapper.updateById(user);

        System.out.println(row);

    }

    @Test
    public void testSelect(){
//        User user = userMapper.selectById(1);
//        System.out.println(user);

//        List<Integer> list = Arrays.asList(1, 2, 3);
//        List<User> users = userMapper.selectBatchIds(list);
//        users.forEach(System.out::println);

        Map<String,Object> map = new HashMap<>();
        map.put("name","梁鹏");
        userMapper.selectByMap(map);
    }

    @Test
    public void testPage(){
        Page<User> page = new Page<>(1,3);
        Page<User> p = userMapper.selectPage(page, null);

        System.out.println(p.getTotal());
        System.out.println(p.getRecords());

    }
}
