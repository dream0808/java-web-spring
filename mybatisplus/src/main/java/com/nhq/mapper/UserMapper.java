package com.nhq.mapper;
import org.apache.ibatis.annotations.Param;

import com.nhq.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author ASUS
* @description 针对表【user】的数据库操作Mapper
* @createDate 2023-07-17 22:11:02
* @Entity com.nhq.pojo.User
*/
public interface UserMapper extends BaseMapper<User> {

    int insertSelective(User user);
}




