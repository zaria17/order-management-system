package com.example.demo.controller;


import com.example.demo.entity.产品库存量;
import com.example.demo.service.产品库存量Service;
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
@RequestMapping("/产品库存量")
public class 产品库存量Controller {
    @Autowired
    private 产品库存量Service cphclService;
    @GetMapping("/list")
    public List<产品库存量> List(){
        return cphclService.list();
    }
}
