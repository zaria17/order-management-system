package com.example.demo.service.impl;

import com.example.demo.entity.订单明细;
import com.example.demo.mapper.订单明细Mapper;
import com.example.demo.service.订单明细Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author watchdoges
 * @since 2024-04-14
 */
@Service
public class 订单明细ServiceImpl extends ServiceImpl<订单明细Mapper, 订单明细> implements 订单明细Service {
    @Resource
    private 订单明细Mapper ddmxMapper;
    @Override
    public boolean delddmx(Integer 订单id, Integer 产品id) {
        return ddmxMapper.delddmx(订单id, 产品id);
    }
}
