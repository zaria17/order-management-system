package com.example.demo.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.demo.common.Result;
import com.example.demo.entity.供应商;
import com.example.demo.entity.客户;
import com.example.demo.service.供应商Service;
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
@RequestMapping("/供应商")
public class 供应商Controller {
    @Autowired
    private 供应商Service gysService;
    @GetMapping("/list")
    public List<供应商> List(){
        return gysService.list();
    }
    //新增
    @PostMapping("/save")
    public Result save(@RequestBody 供应商 gys){
        return Result.suc(gysService.save(gys));
    }
    //修改
    @PostMapping("/mod")
    public Result mod(@RequestBody 供应商 gys){
        return Result.suc(gysService.updateById(gys));
    }
    //新增或修改
    @PostMapping("/saveOrMod")
    public Result saveOrMod(@RequestBody 供应商 gys){
        return Result.suc(gysService.saveOrUpdate(gys));
    }
    //删除
    @GetMapping("/delete")
    public Result delete(Integer 供应商id){
        return Result.suc(gysService.removeById(供应商id));
    }
    //查询
    @PostMapping("/listP")
    public Result listP(@RequestBody 供应商 gys){
        LambdaQueryWrapper<供应商> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(供应商::get公司名称,gys.get公司名称());
        return Result.suc(gysService.list(lambdaQueryWrapper));
    }
    @PostMapping("/listP2")
    public Result listP2(@RequestBody 供应商 gys){
        LambdaQueryWrapper<供应商> lambdaQueryWrapper=new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(供应商::get供应商id,gys.get供应商id());
        return Result.suc(gysService.list(lambdaQueryWrapper));
    }
    @PostMapping("/login")
    public Result login(@RequestBody 供应商 gys){
        List list = gysService.lambdaQuery().eq(供应商::get供应商id,gys.get供应商id())
                .eq(供应商::get密码,gys.get密码()).list();
        return list.size() > 0 ? Result.suc(list.get(0)) : Result.fail();
    }
}
