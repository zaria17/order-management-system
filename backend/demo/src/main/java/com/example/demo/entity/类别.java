package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
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
public class 类别 implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("类别ID")
    private Integer 类别id;

    private String 类别名称;

    private String 说明;

    private String 图片;


}
