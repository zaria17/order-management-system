package com.example.demo.mapper;

import com.example.demo.entity.订单明细;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author watchdoges
 * @since 2024-04-14
 */
@Mapper
public interface 订单明细Mapper extends BaseMapper<订单明细> {

    boolean delddmx(@Param("订单id") Integer 订单id, @Param("产品id") Integer 产品id);
}
