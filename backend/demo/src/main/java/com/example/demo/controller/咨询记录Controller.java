package com.example.demo.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.demo.common.Result;
import com.example.demo.entity.咨询记录;
import com.example.demo.mapper.咨询记录Mapper;
import com.example.demo.service.咨询记录Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author watchdoges
 * @since 2024-04-23
 */
@RestController
@RequestMapping("/咨询记录")
public class 咨询记录Controller {
    @Autowired
    private 咨询记录Service zxjlService;
    @GetMapping("/list")
    public List<咨询记录> list(){
        return zxjlService.list();
    }
    @PostMapping("/save")
    public Result save(@RequestBody 咨询记录 zxjl){
        return Result.suc(zxjlService.save(zxjl));
    }
    @PostMapping("/mod")
    public Result mod(@RequestBody 咨询记录 zxjl){
        return Result.suc(zxjlService.updateById(zxjl));
    }
    @PostMapping("/listP1")
    public Result listP1(@RequestBody 咨询记录 zxjl){
        LambdaQueryWrapper<咨询记录> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(咨询记录::get客户id,zxjl.get客户id());
        return Result.suc(zxjlService.list(lambdaQueryWrapper));
    }
    @PostMapping("/listP2")
    public Result listP2(@RequestBody 咨询记录 zxjl){
        LambdaQueryWrapper<咨询记录> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(咨询记录::get雇员id,zxjl.get雇员id());
        return Result.suc(zxjlService.list(lambdaQueryWrapper));
    }
}
