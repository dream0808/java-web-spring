package com.nhq.service.impl;

import com.nhq.mapper.DeptMapper;
import com.nhq.mapper.EmpMapper;
import com.nhq.pojo.Dept;
import com.nhq.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author hpy
 * @version 1.0
 * @email 929957466h@gmail.com
 * @date 2023/3/26 21:49
 * @description: TODO
 */
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Autowired
    private EmpMapper empMapper;
    @Override
    public List<Dept> list() {
        return deptMapper.list();
    }


    @Transactional(rollbackFor = Exception.class)//开启事务，rollbackFor：回滚的异常类型
    @Override
    public void delete(Integer id) {
        deptMapper.deleteById(id);//根据ID删除部门数据

        empMapper.deleteByDeptId(id);//根据部门ID删除该部门下的员工
    }

    @Override
    public void insert(Dept dept) {

        dept.setUpdateTime(LocalDateTime.now());
        dept.setCreateTime(LocalDateTime.now());

        deptMapper.insert(dept);
    }

    @Override
    public Dept selectById(Integer id) {
        return deptMapper.selectById(id);
    }

    @Override
    public void update(Dept dept) {

        dept.setUpdateTime(LocalDateTime.now());

        deptMapper.update(dept);
    }
}
