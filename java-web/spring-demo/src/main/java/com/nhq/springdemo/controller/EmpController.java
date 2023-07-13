package com.nhq.springdemo.controller;

import com.nhq.springdemo.pojo.Emp;
import com.nhq.springdemo.pojo.Result;
import com.nhq.springdemo.service.EmpService;
import com.nhq.springdemo.service.EmpServiceImpl;
import com.nhq.springdemo.utils.XmlParserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

/**
 * @author hpy
 * @version 1.0
 * @email 929957466h@gmail.com
 * @date 2023/3/26 21:49
 * @description: TODO
 */

@RestController
public class EmpController {


//    @RequestMapping("/listEmp")
//    public Result list(){
//        String file = Objects.requireNonNull(this.getClass().getClassLoader().getResource("emp.xml")).getFile();
//        List<Emp> empList = XmlParserUtils.parse(file, Emp.class);
//
//        empList.stream().forEach(emp -> {
//            String gender = emp.getGender();
//            if("1".equals(gender)){
//                emp.setGender("男");
//            }else if("2".equals(gender)){
//                emp.setGender("女");
//            }
//
//
//            String job = emp.getJob();
//            if("1".equals(job)){
//                emp.setJob("讲师");
//            }else if("2".equals(job)){
//                emp.setJob("班主任");
//            }else if("3".equals(job)){
//                emp.setJob("就业指导");
//            }
//
//
//        });
//
//        return Result.success(empList);
//    }

    @Autowired
    private EmpService empService;
    @RequestMapping("/listEmp")
    public Result list(){
        List<Emp> empList = empService.listEmp();
        return Result.success(empList);
    }
}
