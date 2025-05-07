package com.example.demo.controller;


import com.example.demo.common.Result;
import com.example.demo.entity.不同季节运货量;
import com.example.demo.service.不同季节运货量Service;
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
 * @since 2024-04-20
 */
@RestController
@RequestMapping("/不同季节运货量")
public class 不同季节运货量Controller {
    @Autowired
    private 不同季节运货量Service btjjyhlService;
    @GetMapping("/list")
    public List<不同季节运货量> List(){
        return btjjyhlService.list();
    }
    @GetMapping("/bar")
    public Result bar(){
        List<不同季节运货量> khdqdhlList = btjjyhlService.list();

        Map<Integer,Integer> col = khdqdhlList.stream().collect(Collectors.toMap(不同季节运货量::get季节,不同季节运货量::get运货量));

        List<Integer> xAxis = new ArrayList<>();
        List<Integer> yAxis = new ArrayList<>();
        for(Integer key:col.keySet()){
            xAxis.add(key);
            yAxis.add(col.get(key));
        }

        return Result.suc(yAxis);
    }
}
