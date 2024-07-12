package com.fu.management.controller;

import com.fu.management.pojo.Emp;
import com.fu.management.pojo.PageBean;
import com.fu.management.pojo.Result;
import com.fu.management.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/emps")
public class EmpController {
    @Autowired
    private EmpService empService;

    @GetMapping
    public Result queryPage(@RequestParam(defaultValue = "1") Integer page,
                            @RequestParam(defaultValue = "10") Integer pageSize,
                            String name, Short gender,
                            @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                            @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end) {
        log.info("分页查询");
        PageBean empPageBean = empService.page(page, pageSize, name, gender, begin, end);
        return Result.success(empPageBean);
    }

    @GetMapping("/{id}")
    public Result queryById(@PathVariable Integer id) {
        return Result.success(empService.query(id));
    }

    @DeleteMapping("/{ids}")
    public Result deleteByIds(@PathVariable List<Integer> ids) {
        log.info("批量删除");
        empService.delete(ids);
        return Result.success();
    }

    @PostMapping
    public Result insert(@RequestBody Emp emp) {
        empService.insert(emp);
        return Result.success();
    }

    @PutMapping
    public Result update(@RequestBody Emp emp) {
        empService.update(emp);
        return Result.success();
    }
}
