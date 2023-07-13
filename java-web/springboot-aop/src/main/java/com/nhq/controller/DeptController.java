package com.nhq.controller;

import com.nhq.pojo.Dept;
import com.nhq.pojo.Result;
import com.nhq.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/depts")
public class DeptController {


    @Autowired
    private DeptService deptService;
//    private static Logger log = LoggerFactory.getLogger(DeptController.class);

//    @RequestMapping(value = "/depts",method = RequestMethod.GET)

    /**
     *查询部门数据
     */
    @GetMapping
    public Result list(){
        log.info("查询部门全部数据");

       List<Dept> deptList= deptService.list();

        return Result.success(deptList);
    }


    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        log.info("根据id删除部门：{}",id);

        deptService.delete(id);
        return Result.success();
    }

    @PostMapping
    public Result insert(@RequestBody Dept dept){
        log.info("添加部门");

        deptService.insert(dept);

        return Result.success();
    }

    @GetMapping("/{id}")
    public Result selectById(@PathVariable Integer id){
        Dept dept = deptService.selectById(id);

        return Result.success(dept.getName());
    }


    @PutMapping()
    public Result update(@RequestBody Dept dept){

        deptService.update(dept);

        return Result.success();
    }
}
