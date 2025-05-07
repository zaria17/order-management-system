package com.example.demo.service;

import com.example.demo.entity.订单明细;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author watchdoges
 * @since 2024-04-14
 */
public interface 订单明细Service extends IService<订单明细> {

    boolean delddmx(Integer 订单id,Integer 产品id);
}
