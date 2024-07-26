package com.fu.management.service.impl;

import com.fu.management.mapper.EmpMapper;
import com.fu.management.pojo.Emp;
import com.fu.management.pojo.PageBean;
import com.fu.management.service.EmpService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;

    @Override
    public PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end) {
        PageHelper.startPage(page, pageSize);
        Page<Emp> empPage = empMapper.queryAll(name, gender, begin, end);
        return new PageBean(empPage.getTotal(), empPage.getResult());
    }

    @Override
    public Emp query(Integer id) {
        return empMapper.query(id);
    }

    @Override
    public Integer delete(List<Integer> ids) {
        return empMapper.delete(ids);
    }

    @Override
    public Integer insert(Emp emp) {
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        return empMapper.insert(emp);
    }

    @Override
    public Integer update(Emp emp) {
        emp.setUpdateTime(LocalDateTime.now());
        return empMapper.update(emp);
    }

    @Override
    public Emp login(Emp emp) {
        return empMapper.selectByUsernameAndPassword(emp);
    }
}
