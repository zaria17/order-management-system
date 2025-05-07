package com.example.demo.service;

import com.example.demo.entity.类别;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author watchdoges
 * @since 2024-04-13
 */
public interface 类别Service extends IService<类别> {

    类别 getimage(类别 lb);
}
