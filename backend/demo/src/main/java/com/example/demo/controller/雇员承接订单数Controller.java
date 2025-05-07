package com.example.demo.controller;


import com.example.demo.entity.雇员承接订单数;
import com.example.demo.service.雇员承接订单数Service;
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
@RequestMapping("/雇员承接订单数")
public class 雇员承接订单数Controller {
    @Autowired
    private 雇员承接订单数Service gycjddsService;
    @GetMapping("/list")
    public List<雇员承接订单数> List(){
        return gycjddsService.list();
    }
}
