package com.example.demo.mapper;

import com.example.demo.entity.类别;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author watchdoges
 * @since 2024-04-13
 */
@Mapper
public interface 类别Mapper extends BaseMapper<类别> {

    类别 getimage(类别 lb);
}
