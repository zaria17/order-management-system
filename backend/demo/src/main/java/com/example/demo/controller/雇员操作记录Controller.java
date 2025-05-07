package com.example.demo.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.demo.common.Result;
import com.example.demo.entity.雇员操作记录;
import com.example.demo.service.雇员操作记录Service;
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
@RequestMapping("/雇员操作记录")
public class 雇员操作记录Controller {
    @Autowired
    private 雇员操作记录Service gyczService;
    @GetMapping("/list")
    public List<雇员操作记录> List(){
        return gyczService.list();
    }
    @PostMapping("/save")
    public Result save(@RequestBody 雇员操作记录 gycz){
        return Result.suc(gyczService.save(gycz));
    }
    @PostMapping("/mod")
    public Result mod(@RequestBody 雇员操作记录 gycz){
        return Result.suc(gyczService.updateById(gycz));
    }
    @PostMapping("/saveOrMod")
    public Result saveOrMod(@RequestBody 雇员操作记录 gycz){
        return Result.suc(gyczService.saveOrUpdate(gycz));
    }
    @GetMapping("/delete")
    public Result delete(Integer 记录id){
        return Result.suc(gyczService.removeById(记录id));
    }
    @PostMapping("/listP")
    public Result listP(@RequestBody 雇员操作记录 gycz){
        LambdaQueryWrapper<雇员操作记录> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(雇员操作记录::get操作人,gycz.get操作人());
        return Result.suc(gyczService.list(lambdaQueryWrapper));
    }
}
