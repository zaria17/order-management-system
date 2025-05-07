package com.example.demo.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.demo.common.Result;
import com.example.demo.entity.订单操作记录;
import com.example.demo.service.产品Service;
import com.example.demo.service.订单操作记录Service;
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
@RequestMapping("/订单操作记录")
public class 订单操作记录Controller {
    @Autowired
    private 订单操作记录Service ddczService;
    @GetMapping("/list")
    public List<订单操作记录> List(){
        return ddczService.list();
    }
    @PostMapping("/save")
    public Result save(@RequestBody 订单操作记录 ddcz){
        return Result.suc(ddczService.save(ddcz));
    }
    @PostMapping("/mod")
    public Result mod(@RequestBody 订单操作记录 ddcz){
        return Result.suc(ddczService.updateById(ddcz));
    }
    @PostMapping("/saveOrMod")
    public Result saveOrMod(@RequestBody 订单操作记录 ddcz){
        return Result.suc(ddczService.saveOrUpdate(ddcz));
    }
    @GetMapping("/delete")
    public Result delete(Integer 记录id){
        return Result.suc(ddczService.removeById(记录id));
    }
    @PostMapping("/listP")
    public Result listP(@RequestBody 订单操作记录 ddcz){
        LambdaQueryWrapper<订单操作记录> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(订单操作记录::get操作人,ddcz.get操作人());
        return Result.suc(ddczService.list(lambdaQueryWrapper));
    }
}
