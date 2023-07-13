package com.nhq.springdemo.dao;

import com.nhq.springdemo.pojo.Emp;
import com.nhq.springdemo.utils.XmlParserUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

/**
 * @author hpy
 * @version 1.0
 * @email 929957466h@gmail.com
 * @date 2023/3/26 21:49
 * @description: TODO
 */

@Component
public class EmpDaoImpl implements EmpDao{
    @Override
    public List<Emp> listEmp() {
        String file = Objects.requireNonNull(this.getClass().getClassLoader().getResource("emp.xml")).getFile();
        List<Emp> empList = XmlParserUtils.parse(file, Emp.class);

        return empList;
    }
}
