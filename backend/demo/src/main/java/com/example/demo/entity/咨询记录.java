package com.example.demo.entity;

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
 * @since 2024-04-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class 咨询记录 implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("客户ID")
    private String 客户id;

    @TableField("雇员ID")
    private Integer 雇员id;

    private LocalDateTime 咨询时间;

    private String 咨询内容;

    private LocalDateTime 回复时间;

    private String 回复内容;


}
