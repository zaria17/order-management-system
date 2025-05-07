package com.example.demo.controller;


import com.example.demo.entity.订购库存;
import com.example.demo.service.订购库存Service;
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
 * @since 2024-04-14
 */
@RestController
@RequestMapping("/订购库存")
public class 订购库存Controller {
    @Autowired
    private 订购库存Service dgkcService;
    @GetMapping("/list")
    public List<订购库存> List(){
        return dgkcService.list();
    }
}
