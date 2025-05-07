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
public class 客户 implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("客户ID")
    private String 客户id;

    private String 公司名称;

    private String 联系人姓名;

    private String 联系人职务;

    private String 地址;

    private String 城市;

    private String 地区;

    private String 邮政编码;

    private String 国家;

    private String 电话;

    private String 传真;

    private String 密码;


}
