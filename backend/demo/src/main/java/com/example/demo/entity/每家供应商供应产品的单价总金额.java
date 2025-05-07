package com.example.demo.entity;

import java.math.BigDecimal;
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
public class 每家供应商供应产品的单价总金额 implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("供应商ID")
    private Integer 供应商id;

    private BigDecimal 单价总金额;


}
