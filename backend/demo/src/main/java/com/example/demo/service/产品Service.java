package com.example.demo.service;

import com.example.demo.entity.产品;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author watchdoges
 * @since 2024-04-13
 */
public interface 产品Service extends IService<产品> {

    产品 getname(产品 cp);
}
