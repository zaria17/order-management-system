package com.example.demo.controller;


import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.example.demo.common.Result;
import com.example.demo.entity.客户地区订货量;
import com.example.demo.service.客户地区订货量Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import static java.util.stream.Collectors.*;
import java.util.ArrayList;
import java.util.HashMap;
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
@RequestMapping("/客户地区订货量")
public class 客户地区订货量Controller {
    @Autowired
    private 客户地区订货量Service khdqdhlService;
    @GetMapping("/list")
    public List<客户地区订货量> List(){
        return khdqdhlService.list();
    }
    @GetMapping("/bar")
    public Result bar(){
        List<客户地区订货量> khdqdhlList = khdqdhlService.list();

        Map<String,Integer> col = khdqdhlList.stream().collect(Collectors.toMap(客户地区订货量::get地区,客户地区订货量::get订货量));

        List<String> xAxis = new ArrayList<>();
        List<Integer> yAxis = new ArrayList<>();
        for(String key:col.keySet()){
            xAxis.add(key);
            yAxis.add(col.get(key));
        }

        return Result.suc(yAxis);
    }
}
