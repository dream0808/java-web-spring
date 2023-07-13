package com.nhq.service;

import com.nhq.pojo.Emp;
import com.nhq.pojo.PageBean;

import java.time.LocalDate;
import java.util.List;

/**
 * @author hpy
 * @version 1.0
 * @email 929957466h@gmail.com
 * @date 2023/3/26 21:49
 * @description: TODO
 */
public interface EmpService {
    PageBean page(Integer page, Integer pageSize,
                  String name, Short gender,
                  LocalDate begin, LocalDate end);

    void delete(List<Integer> ids);

    void save(Emp emp);

    Emp selectById(Integer id);

    void update(Emp emp);

    Emp login(Emp emp);
}
