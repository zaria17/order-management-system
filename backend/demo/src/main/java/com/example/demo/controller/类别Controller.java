package com.example.demo.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.demo.common.Result;
import com.example.demo.entity.类别;
import com.example.demo.service.类别Service;
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
@RequestMapping("/类别")
public class 类别Controller {
    @Autowired
    private 类别Service lbService;
    @GetMapping("/list")
    public List<类别> List()
    {
        return lbService.list();
    }
    @PostMapping("/save")
    public Result save(@RequestBody 类别 lb){
        return Result.suc(lbService.save(lb));
    }
    @PostMapping("/mod")
    public Result mod(@RequestBody 类别 lb){
        return Result.suc(lbService.updateById(lb));
    }
    @PostMapping("/saveOrMod")
    public Result saveOrMod(@RequestBody 类别 lb){
        return Result.suc(lbService.saveOrUpdate(lb));
    }
    @GetMapping("/delete")
    public Result delete(Integer 类别id){
        return Result.suc(lbService.removeById(类别id));
    }
    @PostMapping("/listP")
    public Result listP(@RequestBody 类别 lb){
        LambdaQueryWrapper<类别> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(类别::get类别名称,lb.get类别名称());
        return Result.suc(lbService.list(lambdaQueryWrapper));
    }
    @PostMapping("/getimage")
    public String getimage(@RequestBody 类别 lb){
        类别 temp = lbService.getimage(lb);
        return temp.get图片();
    }
}