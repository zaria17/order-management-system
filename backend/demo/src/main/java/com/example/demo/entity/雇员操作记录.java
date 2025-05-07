package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
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
public class 雇员操作记录 implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "记录ID", type = IdType.AUTO)
    private Integer 记录id;

    private LocalDateTime 操作时间;

    private String 操作类型;

    @TableField("雇员ID")
    private Integer 雇员id;

    private String 姓氏;

    private String 名字;

    private String 职务;

    private String 尊称;

    private LocalDateTime 出生日期;

    private LocalDateTime 雇用日期;

    private String 地址;

    private String 城市;

    private String 地区;

    private String 邮政编码;

    private String 国家;

    private String 家庭电话;

    private String 照片;

    private String 备注;

    private String 操作人;


}
