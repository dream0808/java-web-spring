package com.nhq.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.nhq.mapper.EmpMapper;
import com.nhq.pojo.Emp;
import com.nhq.pojo.PageBean;
import com.nhq.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    @Override
    public PageBean page(Integer page, Integer pageSize,
                         String name, Short gender,
                         LocalDate begin, LocalDate end) {

        PageHelper.startPage(page, pageSize);

        List<Emp> list = empMapper.list(name, gender, begin, end);

        Page<Emp> p = (Page<Emp>) list;


        PageBean pageBean = new PageBean(p.getTotal(), p.getResult());

        return pageBean;

    }

    @Override
    public void delete(List<Integer> ids) {
        empMapper.delete(ids);
    }

    @Override
    public void save(Emp emp) {

        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());


        empMapper.insert(emp);
    }

    @Override
    public Emp selectById(Integer id) {

        return empMapper.selectById(id);
    }

    @Override
    public void update(Emp emp) {
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.update(emp);
    }

    @Override
    public Emp login(Emp emp) {

        return empMapper.getByUsernameAndPassword(emp);
    }
//    @Override
//    public PageBean page(Integer page, Integer pageSize) {
//        Long count = empMapper.getCount();
//
//        Integer start = (page -1) * pageSize;
//        List<Emp> empList = empMapper.page(start, pageSize);
//
//        return new PageBean(count, empList);
//    }
}
