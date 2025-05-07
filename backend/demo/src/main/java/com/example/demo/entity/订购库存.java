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
 * @since 2024-04-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class 订购库存 implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("产品ID")
    private Integer 产品id;

    private Integer 库存量;

    private Boolean 中止;


}
