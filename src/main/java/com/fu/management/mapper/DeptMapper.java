package com.fu.management.mapper;

import com.fu.management.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DeptMapper {
    @Select("select * from dept")
    List<Dept> queryAll();

    @Select("select * from dept where id = #{id}")
    Dept query(Integer id);

    @Delete("delete from dept where id = #{id}")
    Integer delete(Integer id);

    @Insert("insert into dept(name, create_time, update_time)" +
            "values(#{name}, now(), now())")
    Integer insert(Dept dept);

    @Update("update dept set name = #{name} where id = #{id}")
    Integer update(Dept dept);
}
