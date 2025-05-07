package com.example.demo.service.impl;

import com.example.demo.entity.雇员;
import com.example.demo.mapper.雇员Mapper;
import com.example.demo.service.雇员Service;
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
public class 雇员ServiceImpl extends ServiceImpl<雇员Mapper, 雇员> implements 雇员Service {
    @Resource
    private 雇员Mapper gyMapper;
    @Override
    public 雇员 getimage(雇员 gy) {
        return gyMapper.getimage(gy);
    }
}
