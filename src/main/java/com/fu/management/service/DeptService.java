package com.fu.management.service;

import com.fu.management.pojo.Dept;

import java.util.List;

public interface DeptService {
    List<Dept> queryAll();
    Dept queryById(Integer id);
    Integer delete(Integer id);
    Integer insert(Dept dept);
    Integer update(Dept dept);
}
