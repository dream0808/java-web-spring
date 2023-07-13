package com.nhq.service;

import com.nhq.pojo.Dept;

import java.util.List;

public interface DeptService {

    /**
     * 查询部门全部数据
     */
    List<Dept> list();

    /**
     * 根据id删除数据
     */
    void delete(Integer id);

    void insert(Dept dept);

    Dept selectById(Integer id);

    void update(Dept dept);
}
