package com.example.demo.mapper;

import com.example.demo.entity.雇员;
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
public interface 雇员Mapper extends BaseMapper<雇员> {

    雇员 getimage(雇员 gy);
}
