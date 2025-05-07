package com.example.demo.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
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
 * @since 2024-04-13
 */
@Data
public class 订单 implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("订单ID")
    private Integer 订单id;

    private LocalDateTime 订购日期;

    private LocalDateTime 发货日期;

    private LocalDateTime 到货日期;

    private LocalDateTime 货款确认日期;

    private BigDecimal 运货费;

    private String 货主名称;

    private String 货主地址;

    private String 货主城市;

    private String 货主地区;

    private String 货主邮政编码;

    private String 货主国家;

    private Integer 折扣id;

    private BigDecimal 货款;

    @TableField("雇员ID")
    private Integer 雇员id;

    @TableField("客户ID")
    private String 客户id;

    private BigDecimal 总金额;


}
