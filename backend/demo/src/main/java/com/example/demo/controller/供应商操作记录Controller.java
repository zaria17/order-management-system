package com.example.demo.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.demo.common.Result;
import com.example.demo.entity.供应商操作记录;
import com.example.demo.service.供应商操作记录Service;
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
@RequestMapping("/供应商操作记录")
public class 供应商操作记录Controller {
    @Autowired
    private 供应商操作记录Service gysczService;
    @GetMapping("/list")
    public List<供应商操作记录> List() {
        return gysczService.list();
    }
    //新增
    @PostMapping("/save")//自增主键
    public Result save(@RequestBody 供应商操作记录 gyscz){
        return Result.suc(gysczService.save(gyscz));
    }
    //修改
    @PostMapping("/mod")
    public Result mod(@RequestBody 供应商操作记录 gyscz){
        return Result.suc(gysczService.updateById(gyscz));
    }
    //新增或修改
    @PostMapping("/saveOrMod")
    public Result saveOrMod(@RequestBody 供应商操作记录 gyscz){
        return Result.suc(gysczService.saveOrUpdate(gyscz));
    }
    //删除
    @GetMapping("/delete")
    public Result delete(Integer 记录id){
        return Result.suc(gysczService.removeById(记录id));
    }
    //查询
    @PostMapping("/listP")
    public Result listP(@RequestBody 供应商操作记录 gyscz){
        LambdaQueryWrapper<供应商操作记录> lambdaQueryWrapper= new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(供应商操作记录::get操作人,gyscz.get操作人());
        return Result.suc(gysczService.list(lambdaQueryWrapper));
    }
}
