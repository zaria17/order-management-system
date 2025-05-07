package com.example.demo.service;

import com.example.demo.entity.订单;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author watchdoges
 * @since 2024-04-13
 */
public interface 订单Service extends IService<订单> {

    List<订单> getNull();
}
