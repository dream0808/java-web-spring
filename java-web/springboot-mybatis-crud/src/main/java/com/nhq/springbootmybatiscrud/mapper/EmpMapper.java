package com.nhq.springbootmybatiscrud.mapper;

import com.nhq.springbootmybatiscrud.pojo.Emp;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;

/**
 * @author hpy
 * @version 1.0
 * @email 929957466h@gmail.com
 * @date 2023/3/26 21:49
 * @description: TODO
 */
@Mapper
public interface EmpMapper {


    //根据ID删除数据
    @Delete("delete from emp where id = #{id}")
    int delete(Integer id);


    //新增员工

    @Options(keyProperty = "id", useGeneratedKeys = true)//获取返回的主键
    @Insert("insert into emp(username, name, gender, image, job, entrydate, dept_id, create_time, update_time)" + "\n" +
            " values (#{username},#{name},#{gender},#{image},#{job},#{entryDate},#{deptId},#{createTime},#{updateTime});")
    int insert(Emp emp);


    @Update("update emp set " +
            "username = #{username} ,name = #{name},gender = #{gender},image=#{image},job = #{job}," +
            "entrydate = #{entryDate},dept_id = #{deptId},update_time = #{updateTime} where id = #{id}")
    int update(Emp emp);


//    @Select("select id, username, password, name, gender, image, job, entrydate, " +
//            "dept_id as deptId, create_time as createTime, update_time as updateTime" +
//            " from emp where id = #{id}")
//     Emp getById(Integer id);

//    @Results({
//            @Result(column = "dept_id" ,property = "deptId"),
//            @Result(column = "create_time" ,property = "createTime"),
//            @Result(column = "update_time" ,property = "updateTime")
//    })
//    @Select("select * from emp where id = #{id}")
//     Emp getById(Integer id);

    @Select("select * from emp where id = #{id}")
    Emp getById(Integer id);


//    @Select("select * from emp " +
//            "where name like '%${name}%' and gender = #{gender} " +
//            "and entrydate between #{begin} and #{end} order by update_time desc;")
//    List<Emp> list(String name, Short gender, LocalDate begin,LocalDate end);


    //    @Select("select * from emp " +
//            "where name like concat('%',#{name},'%') and gender = #{gender} " +
//            "and entrydate between #{begin} and #{end} order by update_time desc;")
//    List<Emp> list(String name, Short gender, LocalDate begin,LocalDate end);
    List<Emp> list(String name, Short gender, LocalDate begin, LocalDate end);


    int update2(Emp emp);

    public int deleteByIds(List<Integer> ids);



    /*
    一、XML映射文件
    1、映射配置文件名与Mapper接口名一致，且放在相同的包下（同包同名）。
    2、映射配置文件的namespace属性与Mapper接口的全类名一致。
    3、XML映射文件中sql语句的id与Mapper接口中的方法名一致。


    二、动态SQL
    <if>
    <where>
    <set
    <foreach>
    <sql>
    <include>
     */
}
