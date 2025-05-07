package com.example.demo.controller;


import com.example.demo.entity.供应商供应特制品数量;
import com.example.demo.service.供应商供应特制品数量Service;
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
@RequestMapping("/供应商供应特制品数量")
public class 供应商供应特制品数量Controller {
    @Autowired
    private 供应商供应特制品数量Service gysgytzpslService;
    @GetMapping("/list")
    public List<供应商供应特制品数量> List() {
        return gysgytzpslService.list();
    }
}
