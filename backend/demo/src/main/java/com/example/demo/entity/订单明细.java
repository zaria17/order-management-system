package com.example.demo.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableId;
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
 * @since 2024-04-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class 订单明细 implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("订单ID")
    private Integer 订单id;

    @TableField("产品ID")
    private Integer 产品id;

    private Integer 数量;

    private BigDecimal 产品总金额;


}
