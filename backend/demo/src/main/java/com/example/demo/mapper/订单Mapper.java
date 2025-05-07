package com.example.demo.mapper;

import com.example.demo.entity.订单;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author watchdoges
 * @since 2024-04-13
 */
@Mapper
public interface 订单Mapper extends BaseMapper<订单> {

    List<订单> getNull();
}
