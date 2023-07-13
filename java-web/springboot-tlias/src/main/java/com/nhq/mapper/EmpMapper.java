package com.nhq.mapper;

import com.nhq.pojo.Emp;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

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



    //原始分页操作
//    @Select("select count(*) from emp;")
//    public Long getCount();


//    /**
//     * 原始分页查询
//     * @param page ：页数
//     * @param pageSize：索引偏移量
//     * @return：用户List
//     */
//    @Select("select id, username, password, name, gender, image, job, entrydate, dept_id, create_time, update_time " +
//            "from emp limit #{page},#{pageSize}")
//    public List<Emp> page(Integer page,Integer pageSize);


    /**
     * pageHelper 插件实现分页，无条件
     * @return: List<Emp> 列表
     */
//    @Select("select * from emp")
//    public List<Emp> list();


    /**
     *插件实现分页，有条件
     * @return : List<Emp> 列表
     */
    public List<Emp> list(String name, Short gender,LocalDate begin, LocalDate end);



    void delete(List<Integer> ids);

    @Insert("insert into emp(username,name, gender,image,job,entrydate,dept_id,create_time,update_time)" +
            "values(#{username},#{name},#{gender},#{image},#{job},#{entrydate},#{deptId},#{createTime},#{updateTime})")
    void insert(Emp emp);

    @Select("select * from emp where id = #{id}")
    Emp selectById(Integer id);

    void update(Emp emp);


    @Select("select * from emp where username = #{username} and password = #{password}")
    Emp getByUsernameAndPassword(Emp emp);

    @Delete("delete from emp where dept_id = #{deptId}")
    void deleteByDeptId(Integer deptId);
}
