package com.example.demo.controller;


import com.example.demo.common.Result;
import com.example.demo.entity.不同地区运货量;
import com.example.demo.service.不同地区运货量Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author watchdoges
 * @since 2024-04-19
 */
@RestController
@RequestMapping("/不同地区运货量")
public class 不同地区运货量Controller {
    @Autowired
    private 不同地区运货量Service btdqyhlService;
    @GetMapping("/list")
    public List<不同地区运货量> List(){
        return btdqyhlService.list();
    }
    @GetMapping("/bar")
    public Result bar(){
        List<不同地区运货量> btdqyhlList = btdqyhlService.list();

        Map<String,Integer> col = btdqyhlList.stream().collect(Collectors.toMap(不同地区运货量::get货主地区,不同地区运货量::get订货量));

        List<String> xAxis = new ArrayList<>();
        List<Integer> yAxis = new ArrayList<>();
        for(String key:col.keySet()){
            xAxis.add(key);
            yAxis.add(col.get(key));
        }

        return Result.suc(yAxis);
    }
}
