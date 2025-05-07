package com.example.demo.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.demo.common.Result;
import com.example.demo.entity.折扣表;
import com.example.demo.service.折扣表Service;
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
@RequestMapping("/折扣表")
public class 折扣表Controller {
    @Autowired
    private 折扣表Service zkService;
    @GetMapping("/list")
    public List<折扣表> List(){
        return zkService.list();
    }
    @PostMapping("/save")
    public Result save(@RequestBody 折扣表 zk){
        return Result.suc(zkService.save(zk));
    }
    @PostMapping("/mod")
    public Result mod(@RequestBody 折扣表 zk){
        return Result.suc(zkService.updateById(zk));
    }
    @PostMapping("saveOrMod")
    public Result saveOrMod(@RequestBody 折扣表 zk){
        return Result.suc(zkService.saveOrUpdate(zk));
    }
    @GetMapping("/delete")
    public  Result delete(Integer 折扣id){
        return Result.suc(zkService.removeById(折扣id));
    }
    @PostMapping("/listP")
    public Result listP(@RequestBody 折扣表 zk){
        LambdaQueryWrapper<折扣表> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(折扣表::get折扣,zk.get折扣());
        return Result.suc(zkService.list(lambdaQueryWrapper));
    }
}
