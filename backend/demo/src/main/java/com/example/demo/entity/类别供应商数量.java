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
 * @since 2024-04-21
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class 类别供应商数量 implements Serializable {

    private static final long serialVersionUID = 1L;

    private String 类别名称;

    @TableField("供应商ID")
    private Integer 供应商id;

    private Integer 数量;


}
