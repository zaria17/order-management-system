package com.example.demo.service.impl;

import com.example.demo.entity.类别;
import com.example.demo.mapper.类别Mapper;
import com.example.demo.service.类别Service;
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
public class 类别ServiceImpl extends ServiceImpl<类别Mapper, 类别> implements 类别Service {
    @Resource
    private 类别Mapper lbMapper;
    @Override
    public 类别 getimage(类别 lb) {
        return lbMapper.getimage(lb);
    }
}
