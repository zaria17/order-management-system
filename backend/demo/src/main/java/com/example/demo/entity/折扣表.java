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
 * @since 2024-04-13
 */
@Data
public class 折扣表 implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer 折扣id;

    private Double 折扣;


}
