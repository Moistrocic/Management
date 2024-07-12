package com.fu.management.service;

import com.fu.management.pojo.Emp;
import com.fu.management.pojo.PageBean;

import java.time.LocalDate;
import java.util.List;

public interface EmpService {
    PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end);
    Emp query(Integer id);
    Integer delete(List<Integer> ids);
    Integer insert(Emp emp);
    Integer update(Emp emp);
}
