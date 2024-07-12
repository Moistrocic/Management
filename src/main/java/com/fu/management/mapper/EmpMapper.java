package com.fu.management.mapper;

import com.fu.management.pojo.Emp;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {
    Page<Emp> queryAll(String name, Short gender, LocalDate begin, LocalDate end);

    @Select("select * from emp where id = #{id}")
    Emp query(Integer id);

    Integer delete(List<Integer> ids);

    Integer insert(Emp emp);

    Integer update(Emp emp);
}
