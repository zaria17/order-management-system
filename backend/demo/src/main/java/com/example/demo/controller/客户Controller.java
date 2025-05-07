package com.example.demo.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.demo.common.Result;
import com.example.demo.entity.客户;
import com.example.demo.entity.雇员;
import com.example.demo.service.客户Service;
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
@RequestMapping("/客户")
public class 客户Controller {
    @Autowired
    private 客户Service khService;
    @GetMapping("/list")
    public List<客户> list(){
        return khService.list();
    }
    //新增
    @PostMapping("/save")
    public Result save(@RequestBody 客户 kh) {
        return Result.suc(khService.save(kh));
    }
    //修改
    @PostMapping("/mod")
    public  Result mod(@RequestBody 客户 kh){
        return Result.suc(khService.updateById(kh));
    }
    //新增或修改
    @PostMapping("/saveOrMod")
    public Result saveOrMod(@RequestBody 客户 kh){
        return Result.suc(khService.saveOrUpdate(kh));
    }
    //删除
    @GetMapping("/delete")
    public  Result delete(String 客户id){
        return  Result.suc(khService.removeById(客户id));
    }
    //查询
    @PostMapping("/listP")
    public Result listP(@RequestBody 客户 kh){
        LambdaQueryWrapper<客户> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(客户::get联系人姓名,kh.get联系人姓名());
        return Result.suc(khService.list(lambdaQueryWrapper));
    }
    @PostMapping("/listP2")
    public Result listP2(@RequestBody 客户 kh){
        LambdaQueryWrapper<客户> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(客户::get客户id,kh.get客户id());
        return Result.suc(khService.list(lambdaQueryWrapper));
    }

    @PostMapping("/login")
    public Result login(@RequestBody 客户 kh){
        List list = khService.lambdaQuery().eq(客户::get客户id,kh.get客户id())
                .eq(客户::get密码,kh.get密码()).list();
        return list.size() > 0 ? Result.suc(list.get(0)) : Result.fail();
    }
}
