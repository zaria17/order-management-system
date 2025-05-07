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
 * @since 2024-04-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class 不同地区运货量 implements Serializable {

    private static final long serialVersionUID = 1L;

    private String 货主地区;

    private Integer 订货量;


}
