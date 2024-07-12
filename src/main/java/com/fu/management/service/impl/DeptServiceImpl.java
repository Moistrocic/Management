package com.fu.management.service.impl;

import com.fu.management.mapper.DeptMapper;
import com.fu.management.pojo.Dept;
import com.fu.management.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;

    @Override
    public List<Dept> queryAll() {
        return deptMapper.queryAll();
    }

    @Override
    public Dept queryById(Integer id) {
        return deptMapper.query(id);
    }

    @Override
    public Integer delete(Integer id) {
        return deptMapper.delete(id);
    }

    @Override
    public Integer insert(Dept dept) {
        return deptMapper.insert(dept);
    }

    @Override
    public Integer update(Dept dept) {
        return deptMapper.update(dept);
    }
}
