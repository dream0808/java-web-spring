package com.nhq.springdemo.service;

import com.nhq.springdemo.dao.EmpDao;
import com.nhq.springdemo.dao.EmpDaoImpl;
import com.nhq.springdemo.pojo.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author hpy
 * @version 1.0
 * @email 929957466h@gmail.com
 * @date 2023/3/26 21:49
 * @description: TODO
 */

@Component
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpDao empDao;
    @Override
    public List<Emp> listEmp() {
        List<Emp> empList = empDao.listEmp();

        empList.forEach(emp -> {
            String gender = emp.getGender();
            if("1".equals(gender)){
                emp.setGender("男");
            }else if("2".equals(gender)){
                emp.setGender("女");
            }


            String job = emp.getJob();
            if("1".equals(job)){
                emp.setJob("讲师");
            }else if("2".equals(job)){
                emp.setJob("班主任");
            }else if("3".equals(job)){
                emp.setJob("就业指导");
            }


        });

        return empList;
    }
}
