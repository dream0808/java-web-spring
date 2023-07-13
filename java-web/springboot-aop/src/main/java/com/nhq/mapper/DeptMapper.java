package com.nhq.mapper;

import com.nhq.pojo.Dept;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author hpy
 * @version 1.0
 * @email 929957466h@gmail.com
 * @date 2023/3/26 21:49
 * @description: TODO
 */
@Mapper
public interface DeptMapper {

    @Select("select id, name, create_time, update_time from dept")
    List<Dept> list();


    @Delete("delete from dept where id = #{id}")
    void deleteById(Integer id);


    @Insert("insert into dept(name,create_time,update_time) values(#{name},#{createTime}, #{updateTime})")
    void insert(Dept dept);


    @Select("select id, name, create_time, update_time from dept where id = #{id}")
    Dept selectById(Integer id);


    //@Update("update dept set name = #{name},create_time = #{createTime},update_time = #{updateTime} where id = #{id}")
    void update(Dept dept);
}
