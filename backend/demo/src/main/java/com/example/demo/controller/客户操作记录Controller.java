package com.example.demo.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.demo.common.Result;
import com.example.demo.entity.客户操作记录;
import com.example.demo.service.客户操作记录Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author watchdoges
 * @since 2024-04-13
 */
@RestController
@RequestMapping("/客户操作记录")
public class 客户操作记录Controller {
    @Autowired
    private 客户操作记录Service khczService;
    @GetMapping("/list")
    public List<客户操作记录> List(){
        return khczService.list();
    }
    @PostMapping("/save")
    public Result save(@RequestBody 客户操作记录 khcz){
        return Result.suc(khczService.save(khcz));
    }
    @PostMapping("/mod")
    public Result mod(@RequestBody 客户操作记录 khcz){
        return Result.suc(khczService.updateById(khcz));
    }
    @PostMapping("/saveOrMod")
    public Result saveOrMod(@RequestBody 客户操作记录 khcz){
        return Result.suc(khczService.saveOrUpdate(khcz));
    }
    @GetMapping("/delete")
    public Result delete(Integer 记录id){
        return Result.suc(khczService.removeById(记录id));
    }
    @PostMapping("/listP")
    public  Result listP(@RequestBody 客户操作记录 khcz){
        LambdaQueryWrapper<客户操作记录> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(客户操作记录::get操作人,khcz.get操作人());
        return Result.suc(khczService.list(lambdaQueryWrapper));
    }
}
