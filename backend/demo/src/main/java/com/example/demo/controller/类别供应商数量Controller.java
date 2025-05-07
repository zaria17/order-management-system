package com.example.demo.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.demo.common.Result;
import com.example.demo.entity.类别供应商数量;
import com.example.demo.service.类别供应商数量Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author watchdoges
 * @since 2024-04-21
 */
@RestController
@RequestMapping("/类别供应商数量")
public class 类别供应商数量Controller {
    @Autowired
    类别供应商数量Service lbgysslService;
    @GetMapping("/list")
    List<类别供应商数量> List(){
        return lbgysslService.list();
    }
    @PostMapping("/listP")
    public Result listP(@RequestBody 类别供应商数量 lbgyssl)
    {
        LambdaQueryWrapper<类别供应商数量> lambdaQueryWrapper= new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(类别供应商数量::get类别名称,lbgyssl.get类别名称());
        return Result.suc(lbgysslService.list(lambdaQueryWrapper));
    }
}
