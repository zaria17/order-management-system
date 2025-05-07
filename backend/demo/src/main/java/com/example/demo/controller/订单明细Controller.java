package com.example.demo.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.demo.common.Result;
import com.example.demo.entity.订单明细;
import com.example.demo.service.订单明细Service;
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
@RequestMapping("/订单明细")
public class 订单明细Controller {
    @Autowired
    private 订单明细Service ddmxService;
    @GetMapping("/list")
    public List<订单明细> List(){
        return ddmxService.list();
    }
    @PostMapping("/save")
    public Result save(@RequestBody 订单明细 ddmx){
        return Result.suc(ddmxService.save(ddmx));
    }
    @PostMapping("/mod")
    public Result mod(@RequestBody 订单明细 ddmx){
        return Result.suc(ddmxService.updateById(ddmx));
    }
    @PostMapping("/saveOrMod")
    public Result saveOrMod(@RequestBody 订单明细 ddmx){
        return Result.suc(ddmxService.saveOrUpdate(ddmx));
    }
    @GetMapping("/delete")
    public Result delete(Integer 订单id,Integer 产品id){
        return Result.suc(ddmxService.delddmx(订单id,产品id));
    }
    @PostMapping("/listP")
    public Result listP(@RequestBody 订单明细 ddmx){
        LambdaQueryWrapper<订单明细> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(订单明细::get订单id,ddmx.get订单id());
        return Result.suc(ddmxService.list(lambdaQueryWrapper));
    }
}
