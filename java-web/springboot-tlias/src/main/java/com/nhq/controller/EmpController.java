package com.nhq.controller;

import com.nhq.anno.Log;
import com.nhq.pojo.Emp;
import com.nhq.pojo.PageBean;
import com.nhq.pojo.Result;
import com.nhq.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

/**
 * @author hpy
 * @version 1.0
 * @email 929957466h@gmail.com
 * @date 2023/3/26 21:49
 * @description: TODO
 */
@Slf4j
@RestController
@RequestMapping("/emps")
public class EmpController {


    @Autowired
    private EmpService empService;

    @GetMapping()
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       String name, Short gender,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end){

        PageBean pageBean = empService.page(page, pageSize, name, gender, begin, end);

        return Result.success(pageBean);
    }

    @Log
    @DeleteMapping("{ids}")
    public Result delete(@PathVariable List<Integer> ids){

        empService.delete(ids);

        return Result.success();
    }
    @Log
    @PostMapping()
    public Result save(@RequestBody Emp emp){

        empService.save(emp);

        return Result.success();
    }

    @GetMapping("{id}")
    public Result selectById(@PathVariable Integer id){

        Emp emp = empService.selectById(id);

        return Result.success(emp);
    }


    @Log
    @PutMapping()
    public Result update(@RequestBody Emp emp){

        empService.update(emp);

        return Result.success();
    }
}
