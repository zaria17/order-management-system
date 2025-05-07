package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author watchdoges
 * @since 2024-04-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class 供应商供应谷类麦片数量 implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("供应商ID")
    private Integer 供应商id;

    private Integer 供应产品数量;


}
