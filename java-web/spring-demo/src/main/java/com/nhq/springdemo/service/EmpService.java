package com.nhq.springdemo.service;

import com.nhq.springdemo.pojo.Emp;

import java.util.List;

public interface EmpService {

    //获取员工列表
    public List<Emp> listEmp();
}
