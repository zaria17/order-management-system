package com.example.demo.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.common.QueryPageParam;
import com.example.demo.common.Result;
import com.example.demo.entity.产品;
import com.example.demo.service.产品Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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
@RequestMapping("/产品")
public class 产品Controller {
    @Autowired
    private 产品Service cpService;
    @GetMapping("/list")
    public List<产品> List() {
        return cpService.list();
    }
    //新增
    @PostMapping("/save")
    public Result save(@RequestBody 产品 cp){
        return Result.suc(cpService.save(cp));
    }
    //修改
    @PostMapping("/mod")
    public Result mod(@RequestBody 产品 cp){
        return Result.suc(cpService.updateById(cp));
    }
    //新增或修改
    @PostMapping("/saveOrMod")
    public Result saveOrMod(@RequestBody 产品 cp){
        return Result.suc(cpService.saveOrUpdate(cp));
    }
    //删除
    @GetMapping("/delete")
    public Result delete(Integer 产品id){
        return Result.suc(cpService.removeById(产品id));
    }
    //查询
    @PostMapping("/listP")
    public Result listP(@RequestBody 产品 cp){
        LambdaQueryWrapper<产品> lambdaQueryWrapper= new LambdaQueryWrapper<>();
        if(StringUtils.isNotBlank(cp.get产品名称())&&cp.get类别id()!= null)
        {
            lambdaQueryWrapper.like(产品::get产品名称,cp.get产品名称())
                    .eq(产品::get类别id,cp.get类别id());
        }
        else if(StringUtils.isNotBlank(cp.get产品名称()))
        {
            lambdaQueryWrapper.like(产品::get产品名称,cp.get产品名称());
        }
        else if(cp.get类别id()!= null)
        {
            lambdaQueryWrapper.eq(产品::get类别id,cp.get类别id());
        }
        return Result.suc(cpService.list(lambdaQueryWrapper));
    }
    @PostMapping("/listP2")
    public Result listP2(@RequestBody 产品 cp){
        LambdaQueryWrapper<产品> lambdaQueryWrapper= new LambdaQueryWrapper<>();
            lambdaQueryWrapper.eq(产品::get产品id,cp.get产品id());
        return Result.suc(cpService.list(lambdaQueryWrapper));
    }
    //分页
    @PostMapping("/listPage")
    public List<产品> listPage(@RequestBody QueryPageParam query)
    {
        System.out.println(query);
        System.out.println("num==="+query.getPageNum());
        System.out.println("size==="+query.getPageSize());
        HashMap param = query.getParam();
        Integer 产品id=(Integer)param.get("产品id");
        String 产品名称=(String)param.get("产品名称");
        System.out.println("产品id==="+(Integer)param.get("产品id"));
        System.out.println("产品名称==="+(String)param.get("产品名称"));
        Page<产品> page=new Page(query.getPageNum(), query.getPageSize());//当前页、每页条数
        LambdaQueryWrapper<产品> lambdaQueryWrapper= new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(产品::get产品名称,产品名称);

        IPage result = cpService.page(page, lambdaQueryWrapper);
        System.out.println("total==="+result.getTotal());

        return result.getRecords();
    }
    //查询产品名称
    @PostMapping("/getname")
    public String getName(@RequestBody 产品 cp){
        产品 temp = cpService.getname(cp);
        return temp.get产品名称();
    }
    @PostMapping("/listP3")
    public Result listP3(@RequestBody 产品 cp){
        LambdaQueryWrapper<产品> lambdaQueryWrapper= new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(产品::get供应商id,cp.get供应商id());
        return Result.suc(cpService.list(lambdaQueryWrapper));
    }
    @PostMapping("/listP4")
    public Result listP4(@RequestBody 产品 cp){
        LambdaQueryWrapper<产品> lambdaQueryWrapper= new LambdaQueryWrapper<>();
        if(StringUtils.isNotBlank(cp.get产品名称())&&cp.get类别id()!= null)
        {
            lambdaQueryWrapper.like(产品::get产品名称,cp.get产品名称())
                    .eq(产品::get类别id,cp.get类别id())
                    .eq(产品::get中止,cp.get中止());
        }
        else if(StringUtils.isNotBlank(cp.get产品名称()))
        {
            lambdaQueryWrapper.like(产品::get产品名称,cp.get产品名称())
                    .eq(产品::get中止,cp.get中止());;
        }
        else if(cp.get类别id()!= null)
        {
            lambdaQueryWrapper.eq(产品::get类别id,cp.get类别id())
                    .eq(产品::get中止,cp.get中止());;
        }
        else {
            lambdaQueryWrapper.eq(产品::get中止,cp.get中止());
        }
        return Result.suc(cpService.list(lambdaQueryWrapper));
    }
    @PostMapping("/listP5")
    public Result listP5(@RequestBody 产品 cp){
        LambdaQueryWrapper<产品> lambdaQueryWrapper= new LambdaQueryWrapper<>();
        if(StringUtils.isNotBlank(cp.get产品名称())&&cp.get类别id()!= null)
        {
            lambdaQueryWrapper.like(产品::get产品名称,cp.get产品名称())
                    .eq(产品::get类别id,cp.get类别id())
                    .eq(产品::get供应商id,cp.get供应商id());
        }
        else if(StringUtils.isNotBlank(cp.get产品名称()))
        {
            lambdaQueryWrapper.like(产品::get产品名称,cp.get产品名称())
                    .eq(产品::get供应商id,cp.get供应商id());
        }
        else if(cp.get类别id()!= null)
        {
            lambdaQueryWrapper.eq(产品::get类别id,cp.get类别id())
                    .eq(产品::get供应商id,cp.get供应商id());
        }
        else{
            lambdaQueryWrapper.eq(产品::get供应商id,cp.get供应商id());
        }
        return Result.suc(cpService.list(lambdaQueryWrapper));
    }
}
