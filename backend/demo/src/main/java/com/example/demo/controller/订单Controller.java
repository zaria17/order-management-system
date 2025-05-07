package com.example.demo.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.demo.common.Result;
import com.example.demo.entity.订单;
import com.example.demo.service.订单Service;
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
@RequestMapping("/订单")//存在问题
public class 订单Controller {
    @Autowired
    private 订单Service ddService;
    @GetMapping("/list")
    public List<订单> List(){
        return ddService.list();
    }
    @PostMapping("/save")
    public Result save(@RequestBody 订单 dd){
        return Result.suc(ddService.save(dd));
    }
    @PostMapping("/mod")
    public Result mod(@RequestBody 订单 dd){
        return Result.suc(ddService.updateById(dd));
    }
    @PostMapping("/saveOrMod")
    public Result saveOrMod(@RequestBody 订单 dd){
        return Result.suc(ddService.saveOrUpdate(dd));
    }
    @GetMapping("/delete")
    public Result delete(Integer 订单id){
        return Result.suc(ddService.removeById(订单id));
    }
    @PostMapping("/listP1")
    public Result listP1(@RequestBody 订单 dd){
        LambdaQueryWrapper<订单> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(订单::get订单id,dd.get订单id());
        return Result.suc(ddService.list(lambdaQueryWrapper));
    }
    @PostMapping("/listP2")
    public Result listP2(@RequestBody 订单 dd){
        LambdaQueryWrapper<订单> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(订单::get客户id,dd.get客户id());
        return Result.suc(ddService.list(lambdaQueryWrapper));
    }
    @PostMapping("/listP3")
    public Result listP3(@RequestBody 订单 dd){
        LambdaQueryWrapper<订单> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(订单::get雇员id,dd.get雇员id());
        return Result.suc(ddService.list(lambdaQueryWrapper));
    }
    @GetMapping("/getnull")
    public Result getnull(){
        return Result.suc(ddService.getNull());
    }
}
