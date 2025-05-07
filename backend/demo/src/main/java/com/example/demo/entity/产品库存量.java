package com.example.demo.entity;

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
public class 产品库存量 implements Serializable {

    private static final long serialVersionUID = 1L;

    private String 产品名称;

    private Integer 库存量;

    private Boolean 中止;


}
