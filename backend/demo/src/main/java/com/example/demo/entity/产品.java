package com.example.demo.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;

/**
 * <p>
 * 
 * </p>
 *
 * @author watchdoges
 * @since 2024-04-13
 */
@Data
public class 产品 implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("产品ID")
    private Integer 产品id;

    private String 产品名称;

    private String 单位数量;

    private BigDecimal 单价;

    private Integer 库存量;

    private Boolean 中止;

    @TableField("类别ID")
    private Integer 类别id;

    @TableField("供应商ID")
    private Integer 供应商id;

    private Integer 订购量;

    private Integer 再订购量;


}
