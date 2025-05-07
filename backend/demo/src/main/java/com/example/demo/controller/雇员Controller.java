package com.example.demo.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.demo.common.Result;
import com.example.demo.entity.雇员;
import com.example.demo.service.雇员Service;
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
@RequestMapping("/雇员")
public class 雇员Controller {
    @Autowired
    private 雇员Service gyService;
    @GetMapping("/list")
    public List<雇员> List(){
        return gyService.list();
    }
    @PostMapping("/save")
    public Result save(@RequestBody 雇员 gy){
        return Result.suc(gyService.save(gy));
    }
    @PostMapping("/mod")
    public Result mod(@RequestBody 雇员 gy){
        return Result.suc(gyService.updateById(gy));
    }
    @PostMapping("/saveOrMod")
    public Result saveOrMod(@RequestBody 雇员 gy){
        return Result.suc(gyService.saveOrUpdate(gy));
    }
    @GetMapping("/delete")
    public Result delete(Integer 雇员id){
        return Result.suc(gyService.removeById(雇员id));
    }
    @PostMapping("/listP")
    public Result listP(@RequestBody 雇员 gy){
        LambdaQueryWrapper<雇员> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(雇员::get名字,gy.get名字());
        return Result.suc(gyService.list(lambdaQueryWrapper));
    }
    @PostMapping("/listP2")
    public Result listP2(@RequestBody 雇员 gy){
        LambdaQueryWrapper<雇员> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(雇员::get雇员id,gy.get雇员id());
        return Result.suc(gyService.list(lambdaQueryWrapper));
    }

    @PostMapping("/login")
    public Result login(@RequestBody 雇员 gy){
        List list = gyService.lambdaQuery().eq(雇员::get雇员id,gy.get雇员id())
                .eq(雇员::get密码,gy.get密码()).list();
        return list.size() > 0 ? Result.suc(list.get(0)) : Result.fail();
    }

    @PostMapping("/getimage")
    public String getimage(@RequestBody 雇员 gy){
        雇员 temp = gyService.getimage(gy);
        return temp.get照片();
    }
}
