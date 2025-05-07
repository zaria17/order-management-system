package com.example.demo.service.impl;

import com.example.demo.entity.订单;
import com.example.demo.mapper.订单Mapper;
import com.example.demo.service.订单Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author watchdoges
 * @since 2024-04-13
 */
@Service
public class 订单ServiceImpl extends ServiceImpl<订单Mapper, 订单> implements 订单Service {
    @Resource
    private 订单Mapper ddMapper;
    @Override
    public List<订单> getNull() {
        return ddMapper.getNull();
    }
}
