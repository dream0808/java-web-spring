package com.nhq.springbootmybatiscrud;

import com.nhq.springbootmybatiscrud.mapper.EmpMapper;
import com.nhq.springbootmybatiscrud.pojo.Emp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class SpringbootMybatisCrudApplicationTests {


    @Autowired
    private EmpMapper empMapper;
    @Test
    public void testDelete(){

        int row = empMapper.delete(16);
        System.out.println(row);
    }

    @Test
    public void testInsert(){
        Emp emp = new Emp();
        emp.setUsername("Tom");
        emp.setName("汤姆");
        emp.setGender((short) 1);
        emp.setDeptId(1);
        emp.setJob((short) 1);
        emp.setImage("1.png");
        emp.setEntryDate(LocalDate.of(2015,01,15));
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());

        int row = empMapper.insert(emp);
        System.out.println(row);
        System.out.println(emp.getId());
    }

    @Test
    public void testUpdate(){
        Emp emp = new Emp();
        emp.setUsername("Bob");
        emp.setName("汤姆");
        emp.setId(20);
        emp.setGender((short) 1);
        emp.setEntryDate(LocalDate.of(2014,5,24));
        emp.setUpdateTime(LocalDateTime.now());
        emp.setDeptId(2);
        emp.setImage("2.png");

        int row = empMapper.update(emp);
        System.out.println(row);
    }

    @Test
    public void testSelectById(){
        Emp emp = empMapper.getById(20);
        System.out.println(emp);

    }

    @Test
    public void testList(){

        LocalDate begin = LocalDate.of(2010, 1, 1);
        LocalDate end = LocalDate.of(2023, 12, 1);

        List<Emp> list = empMapper.list(null, (short)1,null,null);
        System.out.println(list);
    }

    @Test
    public void testUpdate2(){

        Emp emp = new Emp();
        emp.setId(20);
        emp.setUsername("hhhh");
        int row = empMapper.update2(emp);
        System.out.println(row);
    }

    @Test
    public void testDeleteByIds(){
        List<Integer> list = Arrays.asList(18, 17, 20);
        int row = empMapper.deleteByIds(list);
        System.out.println(row);
    }
}














