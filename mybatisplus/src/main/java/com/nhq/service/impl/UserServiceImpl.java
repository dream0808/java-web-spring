package com.nhq.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nhq.pojo.User;
import com.nhq.service.UserService;
import com.nhq.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author ASUS
* @description 针对表【user】的数据库操作Service实现
* @createDate 2023-07-17 22:11:02
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




