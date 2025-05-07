package com.example.demo.controller;


import com.example.demo.entity.每家供应商供应产品的单价总金额;
import com.example.demo.service.每家供应商供应产品的单价总金额Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author watchdoges
 * @since 2024-04-19
 */
@RestController
@RequestMapping("/每家供应商供应产品的单价总金额")
public class 每家供应商供应产品的单价总金额Controller {
    @Autowired
    private 每家供应商供应产品的单价总金额Service mjgysService;
    @GetMapping("/list")
    public List<每家供应商供应产品的单价总金额> List(){
        return mjgysService.list();
    }
}
