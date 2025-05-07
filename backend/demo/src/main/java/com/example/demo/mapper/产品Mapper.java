package com.example.demo.mapper;

import com.example.demo.entity.产品;
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
public interface 产品Mapper extends BaseMapper<产品> {

    产品 getname(产品 cp);
}
