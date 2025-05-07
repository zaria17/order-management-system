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
public class 雇员承接订单数 implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("雇员ID")
    private Integer 雇员id;

    private Integer 订单数量;


}
