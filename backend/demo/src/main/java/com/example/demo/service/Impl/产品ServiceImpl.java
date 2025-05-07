package com.example.demo.service.impl;

import com.example.demo.entity.产品;
import com.example.demo.mapper.产品Mapper;
import com.example.demo.service.产品Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author watchdoges
 * @since 2024-04-13
 */
@Service
public class 产品ServiceImpl extends ServiceImpl<产品Mapper, 产品> implements 产品Service {
    @Resource
    private 产品Mapper cpMapper;
    @Override
    public 产品 getname(产品 cp) {
        return cpMapper.getname(cp);
    }
}
