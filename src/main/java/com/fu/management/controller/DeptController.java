package com.fu.management.controller;

import com.fu.management.pojo.Dept;
import com.fu.management.pojo.Result;
import com.fu.management.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/depts")
public class DeptController {
    @Autowired
    private DeptService deptService;

    @GetMapping
    public Result queryAll() {
        log.info("查询部门表");
        List<Dept> deptList = deptService.queryAll();
        return Result.success(deptList);
    }

    @GetMapping("/{id}")
    public Result queryById(@PathVariable Integer id) {
        log.info("根据id查询部门表");
        Dept dept = deptService.queryById(id);
        return Result.success(dept);
    }

    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable Integer id) {
        log.info("根据id删除部门");
        deptService.delete(id);
        return Result.success();
    }

    @PostMapping
    public Result insert(@RequestBody Dept dept) {
        log.info("添加部门");
        deptService.insert(dept);
        return Result.success();
    }

    @PutMapping
    public Result update(@RequestBody Dept dept) {
        log.info("修改部门");
        deptService.update(dept);
        return Result.success();
    }
}
