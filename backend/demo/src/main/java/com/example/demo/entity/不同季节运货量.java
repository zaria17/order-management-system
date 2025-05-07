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
 * @since 2024-04-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class 不同季节运货量 implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer 季节;

    private Integer 运货量;


}
